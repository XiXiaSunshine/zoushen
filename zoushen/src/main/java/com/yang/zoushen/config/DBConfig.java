package com.yang.zoushen.config;

import com.alibaba.druid.pool.DruidDataSource;

import com.yang.zoushen.dao.UserDao;
import org.mybatis.spring.SqlSessionFactoryBean;

import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;


import javax.sql.DataSource;

import java.io.IOException;

@Configuration
@PropertySource("classpath:db.properties")
@MapperScan(basePackages = "com.yang.zoushen.dao")
public class DBConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public MapperFactoryBean userMapper() throws Exception {
        MapperFactoryBean userMapper = new MapperFactoryBean();
        userMapper.setMapperInterface(UserDao.class);
        userMapper.setSqlSessionFactory(sqlSessionFactory().getObject());
        return userMapper;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(
                resolver.getResources("classpath*:com/yang/zoushen/mapper/*Mapper.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.yang.zoushen.domain");
        return sqlSessionFactoryBean;
    }
}
