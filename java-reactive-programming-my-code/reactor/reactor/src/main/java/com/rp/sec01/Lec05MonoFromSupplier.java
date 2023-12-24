package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {
        // We can use just() only when you have the data already.
//        Mono<String> mono = Mono.just(getName());

        // We can use the Supplier pattern or the Callable interface for a lazy load of the data. This means the method getName() is only called when a subscribe happens. - "Do things only when required."
        Supplier<String> stringSupplier = Lec05MonoFromSupplier::getName;
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext()
        );

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );
    }

    private static String getName(){
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }
}
