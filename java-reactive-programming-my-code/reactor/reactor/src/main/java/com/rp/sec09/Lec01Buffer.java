package com.rp.sec09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01Buffer {
    public static void main(String[] args) {
        eventStream()
                .bufferTimeout(5, Duration.ofSeconds(2))    // A mix of buffer() with a time limit and a amount of items, whichever triggers first.
                .subscribe(Util.subscriber());

        Util.sleepSeconds(30);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(800))
                .map(i -> "event " + i);
    }
}
