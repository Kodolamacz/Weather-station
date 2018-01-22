package com.pp.infa.i_budynki.domain.repo.impl;

import com.pp.infa.i_budynki.domain.Login;
import com.pp.infa.i_budynki.domain.Sensor;
import com.pp.infa.i_budynki.domain.User;
import com.pp.infa.i_budynki.domain.repo.SensorDao;
import com.pp.infa.i_budynki.domain.repo.UserDao;
import com.pp.infa.i_budynki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Blazej on 22.11.2017.
 */
@Repository
public class SensorDaoImpl implements SensorDao {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    @Qualifier("getUserDao")
    @Autowired
    private UserDao userDao;

    public SensorDaoImpl(){
    }
    public SensorDaoImpl(DataSource dataSource){

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Sensor> getSensors(User user) {

        String sql = "SELECT id_czujnika, nazwa_czujnika FROM czujniki c INNER JOIN uzytkownicy u " +
                "on u.id_uzytkownika = c.id_uzytkownika WHERE u.id_uzytkownika = "+user.getId();

        List<Sensor> sensors = new ArrayList<>();
        System.out.println(sql);
        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
            Sensor sensor;
            for (Map row : rows) {
                sensor = new Sensor();
                sensor.setId((Integer) row.get("id_czujnika"));
                sensor.setName((String) row.get("nazwa_czujnika"));
                sensor.setOwner(user.getLogin());
              //  System.out.println(sensor);
                sensors.add(sensor);

            }
            user.setSensorsList(sensors);
        }

        catch (Exception e){
            sensors.add(new Sensor());
            System.out.println("Złapano");
        }

//        for (Sensor x:sensors) {
//            System.out.println(x.getName());
//        }
        return sensors;
    }


    @Override
    public void addSensor(String name, String owner) {

        String sql = "insert into czujniki(nazwa_czujnika, id_uzytkownika) values(?,?)";
        User user = userDao.findUserByName(owner);

        jdbcTemplate.update(sql,name,user.getId());
    }

    @Override
    public Sensor getSensorByName(String name) {

        String query = "Select * from czujniki where nazwa_czujnika = '" + name +"'";

        return jdbcTemplate.query(query, new ResultSetExtractor<Sensor>() {
            @Override
            public Sensor extractData(ResultSet resultSet) throws SQLException, DataAccessException {

                if(resultSet.next()){
                    Sensor sensor = new Sensor();
                    User user = userService.findUserById(resultSet.getInt("id_uzytkownika"));
                    sensor.setId(resultSet.getInt("id_czujnika"));
                    sensor.setName(resultSet.getString("nazwa_czujnika"));
                    sensor.setOwner(user.getLogin());

                    return sensor;
                }
                return null;
            }
        });
    }
    @Override
    public Sensor getSensorById(int id) {

        String query = "Select * from czujniki where id_czujnika = " + id;

        return jdbcTemplate.query(query, new ResultSetExtractor<Sensor>() {
            @Override
            public Sensor extractData(ResultSet resultSet) throws SQLException, DataAccessException {

                if(resultSet.next()){
                    Sensor sensor = new Sensor();
                    User user = userService.findUserById(resultSet.getInt("id_uzytkownika"));
                    sensor.setId(resultSet.getInt("id_czujnika"));
                    sensor.setName(resultSet.getString("nazwa_czujnika"));
                    sensor.setOwner(user.getLogin());

                    return sensor;
                }
                return null;
            }
        });
    }
}
