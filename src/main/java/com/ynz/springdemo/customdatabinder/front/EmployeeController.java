package com.ynz.springdemo.customdatabinder.front;

import com.ynz.springdemo.customdatabinder.domain.Developer;
import com.ynz.springdemo.customdatabinder.domain.Manager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("em")
public class EmployeeController {

    @GetMapping(value = "{id}",params = "developer")
    public Developer getDeveloper(@PathVariable("id") Developer developer) {
        developer.setName("Mike");
        return developer;
    }

    @GetMapping(value = "{id}",params = "manager")
    public Manager getManager(@PathVariable("id") Manager manager) {
        manager.setName("John");
        return manager;
    }

}
