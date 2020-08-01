package com.ynz.springdemo.customdatabinder.converter;

import com.ynz.springdemo.customdatabinder.domain.Name;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToNameObject implements Converter<String, Name> {

    @Override
    public Name convert(String source) {
        return Name.builder().name(source).build();
    }
}
