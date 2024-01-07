package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec07FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1)) // Flux.interval() sets the execution on a parallel pool of threads. That's why it's non-blocking and asynchronous.
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
    }
}
