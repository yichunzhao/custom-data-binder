package com.ynz.springdemo.customdatabinder.converter;

import com.ynz.springdemo.customdatabinder.domain.Color;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEnum implements Converter<String, Color> {
    @Override
    public Color convert(String color) {
        return Color.valueOf(color.toUpperCase());
    }
}
