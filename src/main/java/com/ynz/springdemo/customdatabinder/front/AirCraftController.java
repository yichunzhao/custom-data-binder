package com.ynz.springdemo.customdatabinder.front;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@RestController
@RequestMapping("aircraft")
public class AirCraftController {
    private static final Set<String> fighters;

    static {
        fighters = Stream.of("F15", "F16", "F18", "F22", "F35").collect(toSet());
    }

    @GetMapping("fighter")
    public Set<String> getAllJetFighters() {
        return fighters;
    }

    @GetMapping("fighter/{type}")
    public String getHeaderVersion(@RequestHeader("version") String version, @PathVariable("type") String type) {
        return fighters.stream().filter(s -> s.equalsIgnoreCase(type))
                .map(s -> s.concat(version)).findFirst().orElse("not found");
    }

    @GetMapping("demo/sessionId")
    public String getSessionIdFromCookie(@CookieValue("JSESSIONID") String sessionId){
        return sessionId;
    }

}
