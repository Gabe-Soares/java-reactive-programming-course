package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        Flux<Integer> integerFlux = Flux.fromStream(stream);

        integerFlux.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        // The following code will throw an error, cause the stream reference is the same and is already closed.
        // To solve this problem, we should use list.stream() to get a List reference with the same content as the stream.
        integerFlux.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
