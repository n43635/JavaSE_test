package com.sx.interface_jiekou;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * java8中可以在接口中可以写完整的方法了,可以通过创建默认方法和静态方法来实现
 */
public interface TimeClient {
    void setTime(int hour,int minute,int second);
    void setDate(int day,int month,int year);
    void setDateAndTime(int day,int month,int year,int hour,int minute,int second);
    LocalDateTime getLocalDateTime();

    /**
     * java8前如果想在接口中添加需求,要重新定义一个抽象方法,然后在实现类中去实现,如果有很多实现类,则会增加很多工作量
     */
//    ZonedDateTime getZonedDateTime(String zoneString);


    /**
     * 使用default后可以在接口中直接写方法体,不用在实现类中去重写了,而且实例实现类可以直接使用接口中的default方法
     * @param zoneString
     * @return
     */
    static ZoneId getZoneId (String zoneString){
        try {
            return ZoneId.of(zoneString);
        }catch (DateTimeException e){
            System.err.println("Invalid time zone: " + zoneString +
                    "; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }

    default ZonedDateTime getZonedDateTime(String zoneString){
        return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
    }
}
