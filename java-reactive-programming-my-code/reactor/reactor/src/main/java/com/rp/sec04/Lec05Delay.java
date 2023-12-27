package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.concurrent.Queues;

import java.time.Duration;

public class Lec05Delay {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.x", "9"); // This property is what defines the initial request size.

        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1)) // This operator has a limitRate inside.
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
