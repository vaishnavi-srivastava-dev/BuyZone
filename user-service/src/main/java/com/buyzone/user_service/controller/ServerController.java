package com.buyzone.user_service.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServerController {

    @GetMapping
    public ResponseEntity<String> serverHealth(){
        return new ResponseEntity<>("Buyzone-User-Service: Server is Healthy", HttpStatusCode.valueOf(200));
    }

}
