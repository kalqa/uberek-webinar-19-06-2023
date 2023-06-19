package com.example.uberek;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class BookDateValidator {

//    private final DateService dateService;
//
//    BookDateValidator(DateService dateService) {
//        this.dateService = dateService;
//    }

    String validateBookDate(RideRequest request) {
        LocalDateTime now = request.now();
        LocalDateTime bookDate = request.bookDate();
        if(now.isAfter(bookDate)){
            return "failed";
        }
        return "success";
    }
}
