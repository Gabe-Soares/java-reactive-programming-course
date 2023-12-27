package com.rp.sec04;

import com.rp.courseutil.Util;
import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            System.out.println("Inside create.");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
//            fluxSink.complete();
            fluxSink.error(new RuntimeException("oops"));
            System.out.println("-- Completed.");
        })
                .doOnComplete(() -> System.out.println("doOnComplete."))
                .doFirst(() -> System.out.println("doFirst 1."))
                .doOnNext(o -> System.out.println("doOnNext - " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 1 - " + s))
                .doOnRequest(l -> System.out.println("doOnRequest - " + l))
                .doFirst(() -> System.out.println("doFirst 2."))
                .doOnError(err -> System.out.println("doOnError - " + err))
                .doOnTerminate(() -> System.out.println("doOnTerminate."))
                .doOnCancel(() -> System.out.println("doOnCancel."))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe 2 - " + s))
                .doFinally(signalType -> System.out.println("doFinally - " + signalType))
                .doFirst(() -> System.out.println("doFirst 3."))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard - " + o))
                .take(2)
                .doFinally(signalType -> System.out.println("doFinally 2 - " + signalType)) // To assure that the doFinally lifecycle callback is executed at the end of the pipeline, we should put it between the last subscriber and the last publisher. In this case, after the take() method.
                .subscribe(Util.subscriber());
    }
}
