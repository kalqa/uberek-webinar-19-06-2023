package com.example.uberek;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RideValidatorTest {

    @Test
    public void should_return_success_validation_when_user_gave_correct_request() {
        // given
        RideValidator rideValidator = new RideValidator(new BookDateValidator());
        LocalDateTime now = LocalDateTime.of(2023, 6, 19, 19, 33);
        LocalDateTime bookDate = LocalDateTime.of(2023, 6, 19, 20, 0);
        RideRequest request = new RideRequest(
                "Jana Pawła II",
                "Marcinkowskiego",
                "Poznan",
                now,
                bookDate);
        // when
        String result = rideValidator.validate(request);
        // then
        assertThat(result).isEqualTo("success");
    }

    @Test
    public void should_return_failed_validation_when_user_wanted_book_ride_in_past() {
        // given
        RideValidator rideValidator = new RideValidator(
                new BookDateValidator());
        LocalDateTime now = LocalDateTime.of(2023, 6, 19, 19, 33);
        LocalDateTime bookDate = LocalDateTime.of(2023, 6, 18, 20, 0);
        RideRequest request = new RideRequest(
                "Jana Pawła II",
                "Marcinkowskiego",
                "Poznan",
                now,
                bookDate
        );
        // when
        String result = rideValidator.validate(request);
        // then
        assertThat(result).isEqualTo("failed");
    }


}
