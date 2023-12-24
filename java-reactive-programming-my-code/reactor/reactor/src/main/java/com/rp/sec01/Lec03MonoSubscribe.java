package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        // Publisher.
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l/1);

        // Option 1 - Nothing will happen, cause none behaviour was provided for the OnNext method.
//        mono.subscribe();

        // Option 2 - Implement up to 3 Consumers for the OnNext, OnError and OnComplete methods of Subscriber Object.
        mono.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
