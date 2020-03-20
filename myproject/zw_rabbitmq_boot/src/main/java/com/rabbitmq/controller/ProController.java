package com.rabbitmq.controller;

import com.rabbitmq.simpleness.SimplenessSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pro")
public class ProController {

    @Autowired
    private SimplenessSend simplenessSend;


    @RequestMapping(value = "send")
    public void send(){
        simplenessSend.send();
    }


}
