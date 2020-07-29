package com.ynz.springdemo.customdatabinder.config;

import com.ynz.springdemo.customdatabinder.converter.StringToDate;
import com.ynz.springdemo.customdatabinder.converter.StringToEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@RequiredArgsConstructor
public class AppConfig extends WebMvcConfigurationSupport {

    private final StringToEnum enumToString;
    private final StringToDate stringToDate;

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(enumToString);
        registry.addConverter(stringToDate);
    }

}
