package com.example.uberek;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideController {

    private final RideValidator rideValidator;

    RideController(RideValidator rideValidator) {
        this.rideValidator = rideValidator;
    }

    @PostMapping("/ride")
    public String f(@RequestBody RideRequest request) {
        return rideValidator.validate(request);
    }
}
