package com.pp.infa.i_budynki.domain.repo.impl;

import com.pp.infa.i_budynki.domain.Login;
import com.pp.infa.i_budynki.domain.User;
import com.pp.infa.i_budynki.domain.repo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Blazej on 20.10.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(){}
    public UserDaoImpl(DataSource dataSource){
    jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public boolean register(User user) {

        jdbcTemplate = new JdbcTemplate(dataSource);
        String query = "INSERT INTO Uzytkownicy (imie, nazwisko, nazwa_uzytkownika, haslo, email)"
                + " VALUES(?,?,?,?,?)";

       // String query1 = "SELECT nazwa_uzytkownika FROM Uzytkownicy";

        List<String> loginsList = getLogins();

        if (!loginsList.contains(user.getLogin())) {

           // user.setRoles(Arrays.asList("ROLE_USER"));

            jdbcTemplate.update(query, user.getName(), user.getSurname(), user.getLogin(),
                    passwordEncoder.encode(user.getPassword()), user.getEmail());

            return true;
        } else {

            return false;
        }
    }

    @Override
    public User checkUser(Login login) {


        String query = "SELECT * FROM Uzytkownicy WHERE nazwa_uzytkownika = '" + login.getLogin() + "'";

        User user = jdbcTemplate.query(query, new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {

                if (resultSet.next()) {
                    User user = new User();

                    user.setId(resultSet.getInt("id_uzytkownika"));
                    user.setName(resultSet.getString("imie"));
                    user.setSurname(resultSet.getString("nazwisko"));
                    user.setLogin(resultSet.getString("nazwa_uzytkownika"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("haslo"));

                    return user;
                }
                return null;
            }
        });

        if(user != null) {
            if (passwordEncoder.matches(login.getPassword(), user.getPassword())) {
                return user;

            } else {
                return null;
            }
        }
        else{
            return null;
        }

    }

    @Override
    public User findUserByName(String username) {

        String query = "SELECT * FROM Uzytkownicy WHERE nazwa_uzytkownika = '" + username + "'";
        return jdbcTemplate.query(query, new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {

                if(resultSet.next()){
                    User user = new User();

                    user.setId(resultSet.getInt("id_uzytkownika"));
                    user.setName(resultSet.getString("imie"));
                    user.setSurname(resultSet.getString("nazwisko"));
                    user.setLogin(resultSet.getString("nazwa_uzytkownika"));
                    user.setEmail(resultSet.getString("email"));

                    return user;
                }
                return null;
            }
        });
    }

    @Override
    public List<String> getLogins() {
        String query1 = "SELECT nazwa_uzytkownika FROM Uzytkownicy";
        List<String> loginsList = new ArrayList<String>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query1);
        for (Map row : rows) {
            loginsList.add((String) row.get("nazwa_uzytkownika"));

        }
        return loginsList;
    }

    @Override
    public User findUserById(int id) {
        String query = "SELECT * FROM Uzytkownicy WHERE id_uzytkownika = '" + id + "'";
        return jdbcTemplate.query(query, new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {

                if(resultSet.next()){
                    User user = new User();

                    user.setId(resultSet.getInt("id_uzytkownika"));
                    user.setName(resultSet.getString("imie"));
                    user.setSurname(resultSet.getString("nazwisko"));
                    user.setLogin(resultSet.getString("nazwa_uzytkownika"));
                    user.setEmail(resultSet.getString("email"));

                    return user;
                }
                return null;
            }
        });
    }
}
