package com.JavaReference.example.localDateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class LocalDateTimeDemo {
  public static void main(String[] args) {

    LocalDate localDate = LocalDate.now();
   // System.out.println(localDate);

    LocalDateTime localDateTime = LocalDateTime.now();
   /* System.out.println(localDateTime);
    System.out.println(localDateTime.getDayOfYear());
    System.out.println(localDateTime.getMonth());
    System.out.println(localDateTime.getDayOfWeek());
    System.out.println(localDateTime.getHour());*/

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY/mm/dd HH/mm/ss");
   // System.out.println(localDateTime.format(dateTimeFormatter));

    LocalDate customDate= LocalDate.of(2022, Month.AUGUST,11);
    Period period = Period.between(customDate, localDate);
    /*System.out.println(period);
    System.out.println(period.getDays());
    System.out.println(period.getMonths());
    System.out.println(period.getYears());*/

    LocalDateTime localDateTime1 = LocalDateTime.of(2033, 02, 2, 0, 0);
    LocalDateTime localDateTime2 = LocalDateTime.of(2032, 02, 2, 0, 0);

    Duration between = Duration.between(localDateTime1, localDateTime2);
   // System.out.println(between);
    //System.out.println(between.toDays());


    ZonedDateTime zonedDateTimeTok = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Tokyo"));
    System.out.println(zonedDateTimeTok);

    ZonedDateTime zonedDateTimeUS = ZonedDateTime.of(localDateTime, ZoneId.of("America/Chicago"));
    System.out.println(zonedDateTimeUS);

    long hours = Duration.between(zonedDateTimeTok, zonedDateTimeUS).toHours();
    System.out.println(hours);
  }
}
