package com.APIGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/authServiceFallBack")
    public  String authServiceFallback(){
        return  "Authentication Service is down 7 !";
    }

    @GetMapping("/userServiceFallBack")
    public  String userServiceFallback(){
        return  "User Service is down !";
    }

    @GetMapping("/busServiceFallBack")
    public  String busServiceFallback(){
        return  "Bus Service is down !";
    }

    @GetMapping("/adminServiceFallBack")
    public  String adminServiceFallback(){
        return  "Admin Service is down !";
    }

    @GetMapping("/bookingServiceFallBack")
    public  String bookingServiceFallback(){
        return  "Booking Service is down !";
    }

    @GetMapping("/communicationServiceFallBack")
    public  String communicationServiceFallBack(){
        return  "communication Service is down !";
    }

}
