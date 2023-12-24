package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        //This is the Subscriber.
        userRepository(2)
                .subscribe(Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }

    // Emulating a Publisher.
    private static Mono<String> userRepository(int userId) {
        if(userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        }
        else if(userId == 2) {
            return Mono.empty(); // Equivalent to null.
        }
        else {
            return Mono.error(new RuntimeException("Not in the allowed range."));
        }
    }
}
