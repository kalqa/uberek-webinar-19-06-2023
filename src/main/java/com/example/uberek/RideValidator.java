package com.example.uberek;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RideValidator {

    private final BookDateValidator bookDateValidator;

    RideValidator(BookDateValidator bookDateValidator) {
        this.bookDateValidator = bookDateValidator;
    }

    public String validate(RideRequest request) {
        String bookDateValidationResult = bookDateValidator.validateBookDate(request);
//        String addressValidationResult = addressValidator.validate(request);
        return bookDateValidationResult;
    }


}
