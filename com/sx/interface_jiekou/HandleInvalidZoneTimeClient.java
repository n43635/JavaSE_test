package com.sx.interface_jiekou;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * default方法也可以重写
 */
public interface HandleInvalidZoneTimeClient extends TimeClient {
    @Override
    default ZonedDateTime getZonedDateTime(String zoneString) {
        try {
            return ZonedDateTime.of(getLocalDateTime(), ZoneId.of(zoneString));
        }catch (DateTimeException e){
            System.err.println("Invalid zone ID: " + zoneString +
                    "; using the default time zone instead.");
            return ZonedDateTime.of(getLocalDateTime(), ZoneId.systemDefault());
        }
    }
}
