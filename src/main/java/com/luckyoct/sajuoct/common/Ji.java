package com.luckyoct.sajuoct.common;

import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Ji {
    JA("자", 0),
    CHUG("축", 1),
    IN("인", 2),
    MYO("묘", 3),
    JIN("진", 4),
    SA("사", 5),
    O("오", 6),
    MI("미", 7),
    SIN("신", 8),
    YU("유", 9),
    SUL("술", 10),
    HAE("해", 11),
    ;

    private final String character;
    private final Integer num;

    public static Ji fromTime(LocalTime time) {
        if (time.isBefore(LocalTime.of(1, 30)) || time.isAfter(LocalTime.of(23, 30))) {
            return JA;
        }
        if (time.isBefore(LocalTime.of(3, 30))) {
            return CHUG;
        }
        if (time.isBefore(LocalTime.of(5, 30))) {
            return IN;
        }
        if (time.isBefore(LocalTime.of(7, 30))) {
            return MYO;
        }
        if (time.isBefore(LocalTime.of(9, 30))) {
            return JIN;
        }
        if (time.isBefore(LocalTime.of(11, 30))) {
            return SA;
        }
        if (time.isBefore(LocalTime.of(13, 30))) {
            return O;
        }
        if (time.isBefore(LocalTime.of(15, 30))) {
            return MI;
        }
        if (time.isBefore(LocalTime.of(17, 30))) {
            return SIN;
        }
        if (time.isBefore(LocalTime.of(19, 30))) {
            return YU;
        }
        if (time.isBefore(LocalTime.of(21, 30))) {
            return SUL;
        }
        return HAE;
    }
}
