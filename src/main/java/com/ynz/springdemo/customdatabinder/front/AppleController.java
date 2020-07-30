package com.ynz.springdemo.customdatabinder.front;

import com.ynz.springdemo.customdatabinder.domain.Color;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("apples")
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

    @GetMapping(value = "{date}", params = "date")
    public String getApplesByDate(@PathVariable("date") Date date) {
        return " Apples after date: " + date;
    }

    @GetMapping(value = "{number}", params = "num")
    public String getAppleByNumber(@PathVariable("number") Integer numOfApple) {
        return " Apple number: " + numOfApple;
    }

}
