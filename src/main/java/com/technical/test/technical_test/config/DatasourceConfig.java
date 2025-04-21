package com.technical.test.technical_test.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatasourceConfig {


    @Bean
    public DataSource datasource(){

        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("org.sqlite.JDBC");
        datasource.setUrl("jdbc:sqlite:test.db");
        return datasource;

    }

}
