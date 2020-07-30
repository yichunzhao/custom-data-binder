package com.ynz.springdemo.customdatabinder.domain;

import lombok.Data;

@Data
public class Manager extends Employee {
    private String name;

    public Manager(long id) {
        super(id);
    }

}
