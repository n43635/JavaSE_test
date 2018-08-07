package com.sx.interface_jiekou;

import java.time.ZonedDateTime;

public interface AnotherTimeClient extends TimeClient {

    //可以重新声明默认方法 使它成为抽象方法
    @Override
    ZonedDateTime getZonedDateTime(String zoneString);

}
