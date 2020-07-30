package com.ynz.springdemo.customdatabinder.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LocationTime {
    private String location;
    private String dateTime;
}
