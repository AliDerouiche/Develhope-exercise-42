package com.example.demox1209;

import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/controller")
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Value("${custom.value1}")
    private int value1;

    @Value("${custom.value2}")
    private int value2;

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name) {
        logger.info("Welcome endpoint: {}", name);
        return "Welcome " + name + "!";
    }

    @GetMapping("/calculate")
    public String calculateExponent() {
        logger.debug("Starting calculation");
        int result = (int) Math.pow(value1, value2);
        logger.debug("result");
        return "The result of " + value1 + " raised to the power of " + value2 + " is: " + result;
    }


    @GetMapping("/get-errors")
    public void getErrors() {
        logger.error("Custom exception triggered");
        throw new RuntimeException("This is a custom error");
    }
}
