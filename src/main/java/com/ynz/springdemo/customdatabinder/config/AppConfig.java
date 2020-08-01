package com.ynz.springdemo.customdatabinder.config;

import com.ynz.springdemo.customdatabinder.converter.HeaderLocationTimeArgumentResolver;
import com.ynz.springdemo.customdatabinder.converter.StringToDate;
import com.ynz.springdemo.customdatabinder.converter.StringToEmployeeConverterFactory;
import com.ynz.springdemo.customdatabinder.converter.StringToEnum;
import com.ynz.springdemo.customdatabinder.converter.StringToNameObject;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class AppConfig extends WebMvcConfigurationSupport {

    private final StringToEnum enumToString;
    private final StringToDate stringToDate;
    private final StringToEmployeeConverterFactory stringToEmployeeConverterFactory;
    private final HeaderLocationTimeArgumentResolver headerLocationTimeArgumentResolver;
    private final StringToNameObject stringToNameObject;

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(enumToString);
        registry.addConverter(stringToDate);
        registry.addConverterFactory(stringToEmployeeConverterFactory);
        registry.addConverter(stringToNameObject);
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(headerLocationTimeArgumentResolver);
    }
}
