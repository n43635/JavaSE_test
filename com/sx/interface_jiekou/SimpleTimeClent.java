package com.sx.interface_jiekou;

import java.time.*;

/**
 * TimeClient实现类
 */
public class SimpleTimeClent implements TimeClient {

    private LocalDateTime localDateTime;

    public SimpleTimeClent() {
        localDateTime = LocalDateTime.now();
    }

    @Override
    public void setTime(int hour, int minute, int second) {
        LocalTime localTime = LocalTime.of(hour, minute, second);
        LocalDate localDate = LocalDate.from(localDateTime);
        localDateTime = LocalDateTime.of(localDate, localTime);

    }

    @Override
    public void setDate(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        LocalTime localTime = LocalTime.from(localDateTime);
        localDateTime = LocalDateTime.of(localDate, localTime);

    }

    @Override
    public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
        LocalDate localDate = LocalDate.of(year, month, day);
        LocalTime localTime = LocalTime.of(hour, minute, second);
        localDateTime = LocalDateTime.of(localDate, localTime);

    }

    @Override
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public String toString() {
        return localDateTime.toString();
    }

//    public static void main(String[] args) {
//        SimpleTimeClent simpleTimeClent = new SimpleTimeClent();
//        System.out.println(simpleTimeClent.toString());
//    }

    /**
     * 新添加的方法的实现类,这有一点不好,
     * 所有实现了接口的类都要重写方法,工作量增加,所以在java8中增加了接口中的默认方法和静态方法
     * @param zoneString
     * @return
     */
/*
    @Override
    public ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.of(getLocalDateTime(), getZondId(zoneString));
    }

    static ZoneId getZondId(String zoneString){
        return ZoneId.of(zoneString);
    }

*/

}
