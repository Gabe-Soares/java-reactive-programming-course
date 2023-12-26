package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(
                () -> 1,
                (counter, synchronousSink) -> {
                    var country = Util.faker().country().name();
                    synchronousSink.next(country);

                    if (country.toLowerCase().equals("canada") || counter >= 10) {
                        synchronousSink.complete();
                    }
                    return counter + 1;
                }
        )
                .take(3)
                .subscribe(Util.subscriber());
    }
}
