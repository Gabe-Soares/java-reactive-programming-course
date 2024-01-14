package com.rp.sec08;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02Concat {
    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d", "e");

        Flux<String> flux3 = Flux.error(new RuntimeException("Oops"));

        Flux<String> fluxConcat = Flux.concatDelayError(flux1, flux3, flux2);

        // The code below will result in the same behaviour.
//        Flux<String> fluxConcat = flux1.concatWith(flux2);


        fluxConcat.subscribe(Util.subscriber());
    }
}
