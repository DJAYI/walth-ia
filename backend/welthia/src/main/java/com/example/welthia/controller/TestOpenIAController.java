package com.example.welthia.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.welthia.service.impl.OpenAIService;


@RestController
@RequestMapping("/test-openai")
public class TestOpenIAController {

    private final OpenAIService openAIService;

    public TestOpenIAController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/example")
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    

}
