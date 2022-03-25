package com.puzzle;

import java.time.Duration;
import java.time.LocalTime;

public class Timer {
    static LocalTime start;
    static Long duration; //in seconds

    public static void tick() {
        start = LocalTime.now();
    }
    public static long tock()
    {
        duration = Duration.between(start,LocalTime.now()).getSeconds();

        return duration;
    }
}