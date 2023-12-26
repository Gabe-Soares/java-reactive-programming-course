package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

public class Lec02HandleAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle(
                        (country, sink) -> {
                            sink.next(country);
                            if (country.toLowerCase().equals("canada")) {
                                sink.complete();
                            }
                        }
                )
                .subscribe(Util.subscriber());
    }
}
