package com.pp.infa.i_budynki.config;

import com.pp.infa.i_budynki.domain.repo.impl.MeasureDaoImpl;
import com.pp.infa.i_budynki.domain.repo.impl.SensorDaoImpl;
import com.pp.infa.i_budynki.domain.repo.impl.UserDaoImpl;
import com.pp.infa.i_budynki.service.impl.UserDetailService;
import com.pp.infa.i_budynki.validators.EmailValidator;
import com.pp.infa.i_budynki.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

/**
 * Created by Blazej on 18.10.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.pp.infa.i_budynki.*")
@PropertySource("classpath:db.properties")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private Environment env;


    @Bean
    public ViewResolver viewResolvers() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        //viewResolver.setExposeContextBeansAsAttributes(true);
        //registry.viewResolver(viewResolver);

        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.d"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.login"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public UserDaoImpl getUserDao() {
        return new UserDaoImpl(dataSource());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resource/**").addResourceLocations("/resources/");
    }


    @Bean
    public UserDetailService getUserDetail() {
        return new UserDetailService();
    }


    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public EmailValidator emailValidator() {
        return new EmailValidator();
    }

    @Bean
    public PasswordValidator passwordValidator() {
        return new PasswordValidator();
    }

    @Bean
    public SensorDaoImpl getSensorDao(){
        return new SensorDaoImpl(dataSource());
    }

    @Bean
    public MeasureDaoImpl getMeasureDao(){
        return new MeasureDaoImpl(dataSource());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer
    propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
