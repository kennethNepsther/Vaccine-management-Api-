package com.vacinas.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class DateTimeUtil {

    private DateTimeUtil() {
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now(Clock.systemDefaultZone());
    }

    public static LocalTime getCurrentTime() {
        return LocalTime.now(Clock.systemDefaultZone());
    }

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now(Clock.systemDefaultZone());
    }

}
