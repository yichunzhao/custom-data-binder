package com.ynz.springdemo.customdatabinder.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Pet {
    private long ownerId;
    private String name;
    private Date birthDate;
}
