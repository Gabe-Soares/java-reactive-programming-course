package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        // The Flux.create is thread safe, meaning that it can work with multiple threads. Unlike, the Flux.push is not thread safe.
        // When Flux.push is used with multiple threads, it could happen that some threads is lost, never reaching it's supposed behaviour.
        Flux.push(nameProducer)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}
