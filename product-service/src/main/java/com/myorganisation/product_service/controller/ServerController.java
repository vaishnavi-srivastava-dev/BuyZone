package com.myorganisation.product_service.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServerController {

    @GetMapping
    public ResponseEntity<String> getServerHealth(){
        return new ResponseEntity<>("Product Service is healthy", HttpStatusCode.valueOf(200));
    }
}
