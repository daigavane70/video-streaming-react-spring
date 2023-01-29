package com.sprint.common.utils;

import com.sprint.common.constants.Constants;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class CommonUtils {


    public static double truncateToFixedDecimals(double number) {
        return truncateToFixedDecimals(number, 2);
    }

    public static double truncateToFixedDecimals(double number, int numOfPlaces) {
        final double exponent = Math.pow(10d, numOfPlaces);
        return Math.round((number * exponent)) / exponent;
    }

    public static LocalDateTime stringToLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT);
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        return dateTime;
    }

    public static String encodePassword(String data) {
        return Base64.getUrlEncoder().encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }
}
