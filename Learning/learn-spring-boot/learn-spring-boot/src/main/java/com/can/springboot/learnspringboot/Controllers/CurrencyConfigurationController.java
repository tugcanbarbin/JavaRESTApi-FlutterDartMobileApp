package com.can.springboot.learnspringboot.Controllers;

import com.can.springboot.learnspringboot.Classes.CurrencyServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration config;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllCourses()
    {
        return config;
    }

}
