package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(integer -> integer > 10)
                .switchIfEmpty(fallback()) // The deaultIfEmpty is used for returning a constant value. switchIfEmpty in the other hand is capable of providing a new Publisher.
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }

    private static Flux<Integer> fallback() {
        return Flux.range(20, 10);
    }
}
