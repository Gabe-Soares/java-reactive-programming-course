package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
        Mono.fromRunnable(timeComsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process is done. Sending e-mails...");
                        });
    }

    private static Runnable timeComsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation Completed.");
        };
    }
}
