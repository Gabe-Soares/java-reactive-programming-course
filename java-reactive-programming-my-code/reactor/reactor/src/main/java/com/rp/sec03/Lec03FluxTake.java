package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {
    public static void main(String[] args) {
        // Operators are methods to decorate a FLux/Mono pipeline, such as map, filter, log and take.
        Flux.range(1, 10)
                .log()
                .take(3) // After the third signal, this operator cancels the subscription.
                .log()
                .subscribe(Util.subscriber());
    }
}
