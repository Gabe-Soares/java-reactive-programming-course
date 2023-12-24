package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log() // This shows the logs for the Publisher (Flux.range) and the Subscriber (map).
                .map(i -> Util.faker().name().fullName())
                .log() // This shows the logs for the Publisher (map) and the Subscriber (subscribe).
                .subscribe(Util.onNext());
    }
}
