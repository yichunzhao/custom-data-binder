package com.ynz.springdemo.customdatabinder.front;

import com.ynz.springdemo.customdatabinder.domain.Developer;
import com.ynz.springdemo.customdatabinder.domain.Manager;
import com.ynz.springdemo.customdatabinder.domain.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring MVC handler method arguments; auto injected by framework, fx: ServletRequest, HttpSession, WebRequest
 */
@RestController
@RequestMapping("em")
public class EmployeeController {

    @GetMapping(value = "{id}", params = "developer")
    public Developer getDeveloper(@PathVariable("id") Developer developer) {
        developer.setName("Mike");
        return developer;
    }

    @GetMapping(value = "{id}", params = "manager")
    public Manager getManager(@PathVariable("id") Manager manager) {
        manager.setName("John");
        return manager;
    }

    @GetMapping("{name}")
    public Name getEmName(@PathVariable("name") Name emMame) {
        return emMame;
    }

    @GetMapping(value = "start-date")
    public String getHeaderDate(@RequestHeader("start-date") Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date).toString();
    }

    @GetMapping(value = "servlet-request")
    public Map<String, String> getRequestDetail(ServletRequest request) {
        Map<String, String> result = new HashMap<>();
        result.put("CharacterEncoding", request.getCharacterEncoding());
        result.put("Content-Type", request.getContentType());
        result.put("Local-Name", request.getLocalName());
        result.put("Server-Name", request.getServerName());
        result.put("Schema", request.getScheme());
        result.put("Locale", request.getLocale().toString());
        result.put("isAsyncSupport", Boolean.toString(request.isAsyncSupported()));

        return result;
    }

    @GetMapping("session-timeout")
    public String getHttpSession(HttpSession httpSession) {
        return "session-timeout: " + httpSession.getServletContext().getSessionTimeout();
    }

    @GetMapping("header-names")
    public Map<String, String[]> getWebRequest(WebRequest webRequest) {
        Map<String, String[]> headers = new HashMap<>();
        webRequest.getHeaderNames().forEachRemaining(s -> headers.put(s, webRequest.getHeaderValues(s)));
        return headers;
    }

}
