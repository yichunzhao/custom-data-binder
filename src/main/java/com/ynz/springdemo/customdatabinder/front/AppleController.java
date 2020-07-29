package com.ynz.springdemo.customdatabinder.front;

import com.ynz.springdemo.customdatabinder.domain.Color;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apple")
public class AppleController {

    @GetMapping("{color}")
    public String getAppleByColor(@PathVariable("color") Color color) {
        String apple = null;

        switch (color) {
            case RED:
                apple = "red apple";
                break;
            case YELLOW:
                apple = "yellow apple ";
                break;
            case GREEN:
                apple = "green apple";
                break;
            default:
                apple = "invalid request";
        }

        return apple;
    }

}
