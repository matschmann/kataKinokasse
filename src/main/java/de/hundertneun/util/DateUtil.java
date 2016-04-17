package de.hundertneun.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static DayOfWeek parseDay(String dayAsString) {
        switch (dayAsString) {
            case "Mo":
                return DayOfWeek.MONDAY;
            case "Di":
                return DayOfWeek.TUESDAY;
            case "Mi":
                return DayOfWeek.WEDNESDAY;
            case "Do":
                return DayOfWeek.THURSDAY;
            case "Fr":
                return DayOfWeek.FRIDAY;
            case "Sa":
                return DayOfWeek.SATURDAY;
            case "So":
                return DayOfWeek.SUNDAY;
            default:
                throw new RuntimeException("Day of week " + dayAsString + " unknown.");
        }
    }

    public static LocalDate nextDayOfWeek(DayOfWeek dayOfWeek, LocalDate locaDate) {
        int daysTillNext = dayOfWeek.getValue() - locaDate.getDayOfWeek().getValue();

        if (daysTillNext < 0) {
            daysTillNext += 7;
        }

        return locaDate.plusDays(daysTillNext);
    }

    public static LocalTime parseTime(String time) {
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    }
}
