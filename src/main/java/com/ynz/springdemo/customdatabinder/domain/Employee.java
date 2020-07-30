package com.ynz.springdemo.customdatabinder.domain;

import lombok.Data;

@Data
public abstract class Employee {
    protected long id;

    public Employee(long id) {
        this.id = id;
    }
}
