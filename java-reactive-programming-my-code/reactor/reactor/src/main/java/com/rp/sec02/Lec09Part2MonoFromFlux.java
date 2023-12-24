package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09Part2MonoFromFlux {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next() // The very first item to be emitted to this method on the pipeline is the item that will be provided to the Mono.
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
