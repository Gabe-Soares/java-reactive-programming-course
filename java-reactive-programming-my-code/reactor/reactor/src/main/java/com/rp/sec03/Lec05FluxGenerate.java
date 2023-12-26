package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                System.out.println("Emitting...");
                synchronousSink.next(Util.faker().country().name());
//                synchronousSink.next(Util.faker().country().name()); // This line will throw an error since SynchronousSink can only emit one signal (even though it emits in a loop).
        })
                .take(2)
                .subscribe(Util.subscriber());
    }
}
