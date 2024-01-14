package com.rp.sec08;

import com.rp.courseutil.Util;
import com.rp.sec08.helper.AmericanAirlines;
import com.rp.sec08.helper.Emirates;
import com.rp.sec08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lec04Zip {
    public static void main(String[] args) {
        Flux.zip(getBody(), getEngine(), getTires())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }

    private static Flux<String> getBody() {
        return Flux.range(1, 5)
                .map(i -> "body");
    }

    private static Flux<String> getEngine() {
        return Flux.range(1, 3)
                .map(i -> "engine");
    }

    private static Flux<String> getTires() {
        return Flux.range(1, 6)
                .map(i -> "tires");
    }
}
