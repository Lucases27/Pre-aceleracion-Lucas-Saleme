package com.alkemy.disney.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {


    public static LocalDate string2LocalDate(String stringDate){
        LocalDate date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        try {
            date = LocalDate.parse(stringDate,formatter);
        }catch(DateTimeParseException e){
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            date = LocalDate.parse(stringDate,formatter);
        }
        return date;
    }
}
