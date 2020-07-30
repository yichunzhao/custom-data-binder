package com.ynz.springdemo.customdatabinder.front;

import com.ynz.springdemo.customdatabinder.converter.HeadLocation;
import com.ynz.springdemo.customdatabinder.domain.LocationTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("location")
public class LocationTimeController {

    @GetMapping()
    public LocationTime getLocationTimeFromHeader(@HeadLocation LocationTime locationTime){
        return locationTime;
    }
}
