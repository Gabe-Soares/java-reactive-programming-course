package com.rp.sec06;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Parallel {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .parallel(2) // This argument sets the number of threads it should split the execution on.
                .runOn(Schedulers.boundedElastic())
                .doOnNext(o -> printThreadName("next " + o))
                .subscribe(v -> printThreadName("sub " + v));

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t- Thread: " + Thread.currentThread().getName());
    }
}
