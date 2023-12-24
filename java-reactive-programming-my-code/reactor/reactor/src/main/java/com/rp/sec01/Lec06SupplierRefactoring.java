package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        getName(); // When we don't subscribe, the pipeline is only built and returned.
        getName().subscribe(Util.onNext()); // But when we do subscribe, then the publisher executes the pipeline and ask for the Supplier to provide the data.
        String name = getName().subscribeOn(Schedulers.boundedElastic()) // Make the subscribe work as async and non-blocking.
                .block(); // Make the async Mono work as a blocking execution.
        System.out.println("Name: " + name);
        getName();

        // All of this code is working synchronously.
    }

    private static Mono<String> getName(){
        System.out.println("Entered getName method.");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
