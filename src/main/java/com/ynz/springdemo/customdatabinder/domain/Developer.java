package com.ynz.springdemo.customdatabinder.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Developer extends Employee {
    private String name;

    public Developer(long id) {
        super(id);
    }

}
