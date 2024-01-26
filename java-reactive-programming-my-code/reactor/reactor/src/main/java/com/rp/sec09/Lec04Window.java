package com.rp.sec09;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec04Window {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        eventStream()
                .window(5)
                .flatMap(flux -> saveEvents(flux))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(30);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> "event " + i);
    }

    private static Mono<Integer> saveEvents(Flux<String> flux) {
        return flux.doOnNext(i -> System.out.println("saving " + i))
                .doOnComplete(() -> {
                    System.out.println("saved this batch");
                    System.out.println("-----------------");
                })
                .then(Mono.just(atomicInteger.getAndIncrement()));
    }
}
