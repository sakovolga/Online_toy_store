package com.example.online_toy_store.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class MapperUtil {
    public LocalDateTime getFirstDayOfMonth(String year, String month) {
        int parsedYear = Integer.parseInt(year);
        int parsedMonth = Integer.parseInt(month);
        return LocalDateTime.of(parsedYear, parsedMonth, 1, 0, 0);
    }

    public LocalDateTime getLastDayOfMonth(String year, String month) {
        int parsedYear = Integer.parseInt(year);
        int parsedMonth = Integer.parseInt(month);
        int daysInMonth = java.time.YearMonth.of(parsedYear, parsedMonth).lengthOfMonth();
        return LocalDateTime.of(parsedYear, parsedMonth, daysInMonth, 23, 59, 59);
    }
}
