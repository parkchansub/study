package tobyspring.hellospring.learningtest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockTest {

    //Clock 이용해서 LocalDateTime.now?
    @Test
    void clock() {
        Clock clock = Clock.systemDefaultZone();

        LocalDateTime dtl1 = LocalDateTime.now(clock);
        LocalDateTime dtl2 = LocalDateTime.now(clock);

        Assertions.assertThat(dtl2).isAfter(dtl1);
    }


    @Test
    void fixedClock() {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
        LocalDateTime dtl1 = LocalDateTime.now(clock);
        LocalDateTime dtl2 = LocalDateTime.now(clock);
        LocalDateTime dtl3 = LocalDateTime.now(clock).plusHours(1);

        Assertions.assertThat(dtl1).isEqualTo(dtl2);
        Assertions.assertThat(dtl3).isEqualTo(dtl1.plusHours(1));
    }


}
