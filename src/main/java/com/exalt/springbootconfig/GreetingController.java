package com.exalt.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting: default value}")
    private String greetingMessage;

    @Value("static message")
    private String staticMessage;

    @Value("${my.list.value}")
    private List<String> listValues;

    @Autowired
    private Environment env;

//    @Value("#{${dbValues}}")
//    private Map<String, String> dbValues;

    @Autowired
    private DBSettings dbSettings;


    @GetMapping("/greeting")
    public String greeting() {
        return dbSettings.getConnection() + dbSettings.getHost() + listValues + greetingMessage;
    }

    @GetMapping("/envdetails")
    public String envdetails() {
        return env.toString();
    }
}
