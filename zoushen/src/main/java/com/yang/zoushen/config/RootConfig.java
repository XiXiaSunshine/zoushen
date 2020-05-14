package com.yang.zoushen.config;

import com.yang.zoushen.exception.ZsExceptionResolver;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@Configuration
@ComponentScan(
        basePackages = {"com"},
        excludeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = {EnableWebMvc.class})
        })
@ImportResource(locations = "classpath:application.xml")

public class RootConfig {

        @Bean
        public HandlerExceptionResolver exceptionResolver(){
                return new ZsExceptionResolver();
        }
}
