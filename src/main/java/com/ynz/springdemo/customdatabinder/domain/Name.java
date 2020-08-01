package com.ynz.springdemo.customdatabinder.domain;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Name {
    private String name;
}
