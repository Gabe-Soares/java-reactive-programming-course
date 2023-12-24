package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1, 2, 3, 4, "a", Util.faker().name().fullName());

        flux.subscribe(Util.onNext());
    }
}
