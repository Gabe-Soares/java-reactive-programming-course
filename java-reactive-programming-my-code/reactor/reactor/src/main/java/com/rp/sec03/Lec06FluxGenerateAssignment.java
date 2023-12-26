package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            System.out.println("Emitting country...");
            var country = Util.faker().country().name();
            synchronousSink.next(country);

            if(country.toLowerCase().equals("canada")){
                synchronousSink.complete();
            }})
                .take(10)
                .subscribe(Util.subscriber());
    }
}
