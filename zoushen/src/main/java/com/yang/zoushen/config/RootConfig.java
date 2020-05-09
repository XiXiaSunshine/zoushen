package com.yang.zoushen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(
        basePackages = {"com"},
        excludeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = {EnableWebMvc.class})
        })
@ImportResource(locations = "classpath:application.xml")

public class RootConfig {
}
