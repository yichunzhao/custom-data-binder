package com.ynz.springdemo.customdatabinder.front;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

/**
 * Spring MVC, Method Arguments
 * <p>
 * Key-value stored in Session, Cookie, Request, can be bound by @SessionAttribute, @CookieValue, @RequestAttribute
 * to method argument parameters.</p>
 * <p>
 * JDK 8 Optional type is supported as a method argument in combination with annotations that have a <i>required</i>
 * attribute, and is equivalent to <code>required=false</code>.
 * </p>
 */

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
    public String getHeaderVersion(@RequestHeader(value = "version", required = false) Optional<String> version, @PathVariable("type") String type) {

        return fighters.stream().filter(s -> s.equalsIgnoreCase(type))
                .map(s -> s.concat(version.orElse(""))).findFirst().orElse("not found");
    }

    @GetMapping("demo/sessionId")
    public String getSessionIdFromCookie(@CookieValue("JSESSIONID") String sessionId) {
        return sessionId;
    }

}
