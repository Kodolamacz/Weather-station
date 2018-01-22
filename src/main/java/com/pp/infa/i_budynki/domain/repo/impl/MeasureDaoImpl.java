package com.pp.infa.i_budynki.domain.repo.impl;

import com.pp.infa.i_budynki.domain.Measure;
import com.pp.infa.i_budynki.domain.Sensor;
import com.pp.infa.i_budynki.domain.repo.MeasureDao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Blazej on 22.11.2017.
 */
@Repository
public class MeasureDaoImpl implements MeasureDao {

    private JdbcTemplate jdbcTemplate;

    public MeasureDaoImpl(){}
    public MeasureDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Map<Object, Object> getSensorData(Sensor sensor) {

        String sql = "select  m.id_miary, p.wartosc, m.nazwa_miary, m.jednostka, p.czas_pomiaru from pomiary p " +
                "inner join miary m on m.id_miary = p.id_miary where p.id_czujnika = "+sensor.getId();

        Map<Object,Object> data = new LinkedHashMap<>();
        List<Double> values = new ArrayList<>();
        List<Timestamp> times = new ArrayList<>();
        List<Double> humidityValues = new ArrayList<>();

        try {

            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            for (Map row : rows) {

                times.add((Timestamp) row.get("czas_pomiaru"));
                if((Integer) row.get("id_miary") == 1){

                    humidityValues.add((Double) row.get("wartosc"));
                    data.put("humUnit", row.get("jednostka"));
                }
                else {

                    values.add((Double) row.get("wartosc"));
                    data.put("unit",row.get("jednostka"));
                }
            }

            if(humidityValues.size() != 0){

              data.put("hum",humidityValues);

            }

            data.put("sensor",sensor);
            data.put("values",values);
            data.put("time",times);
            //
            //

        }

        catch (Exception e){

            System.out.println("Złapano" );
            e.printStackTrace();
        }
        return data;
    }


    public Map<Object, Object> getSensorData(Sensor sensor,String begin, String end, Double min, Double max) {

        String sql = "select  m.id_miary, p.wartosc, m.nazwa_miary, m.jednostka, p.czas_pomiaru from pomiary p " +
                "inner join miary m on m.id_miary = p.id_miary where p.id_czujnika = "+sensor.getId() + " " +
                "AND (DATE(p.czas_pomiaru) BETWEEN " + begin + " AND " + end +
                " OR p.wartosc BETWEEN " + min + " AND " + max + ")";

        System.out.println("############ Zapytanie w funkcji: " + sql);
        Map<Object,Object> data = new LinkedHashMap<>();
        List<Double> values = new ArrayList<>();
        List<Timestamp> times = new ArrayList<>();
        List<Double> humidityValues = new ArrayList<>();

        try {

            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            for (Map row : rows) {

                times.add((Timestamp) row.get("czas_pomiaru"));
                if((Integer) row.get("id_miary") == 1){

                    humidityValues.add((Double) row.get("wartosc"));
                    data.put("humUnit", row.get("jednostka"));
                }
                else {

                    values.add((Double) row.get("wartosc"));
                    data.put("unit",row.get("jednostka"));
                }
            }

            if(humidityValues.size() != 0){

                data.put("hum",humidityValues);

            }

            data.put("sensor",sensor);
            data.put("values",values);
            data.put("time",times);
            //
            //

        }

        catch (Exception e){

            System.out.println("Złapano" );
            e.printStackTrace();
        }
        return data;
    }

}
