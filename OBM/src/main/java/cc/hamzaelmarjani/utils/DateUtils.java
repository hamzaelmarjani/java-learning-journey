package cc.hamzaelmarjani.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public Date parse(int year, int month, int day, int hour, int minute, int second) {
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
        ZonedDateTime zoned = localDateTime.atZone(ZoneId.systemDefault());
        return Date.from(zoned.toInstant());
    }

    public String humanReadableDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd MMM yyyy, hh:mm:ss a", Locale.ENGLISH);
        return now.format(formatter);
    }

    public String humanReadableDate(Date date) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE dd MMM yyyy, hh:mm:ss a", Locale.ENGLISH);
        return now.format(formatter);
    }
}
