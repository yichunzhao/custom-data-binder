package com.ynz.springdemo.customdatabinder.converter;

import com.ynz.springdemo.customdatabinder.domain.Developer;
import com.ynz.springdemo.customdatabinder.domain.Employee;
import com.ynz.springdemo.customdatabinder.domain.Manager;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

@Component
public class StringToEmployeeConverterFactory implements ConverterFactory<String, Employee> {
    @Override
    public <T extends Employee> Converter<String, T> getConverter(Class<T> targetType){

        return new StringToEmployeeConverter(targetType);
    }

    @AllArgsConstructor
    private class StringToEmployeeConverter<T extends Employee> implements Converter<String, T> {
        private Class<T> targetType;

        @Override
        public T convert(String source) {
            long id = Long.parseLong(source);

            if (targetType == Developer.class) {
                return (T) new Developer(id);
            } else if (targetType == Manager.class) {
                return (T) new Manager(id);
            } else {
                return null;
            }
        }
    }
}
