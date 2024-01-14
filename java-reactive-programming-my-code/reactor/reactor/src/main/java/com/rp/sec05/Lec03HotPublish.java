package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {
    public static void main(String[] args) {
        // share() == publish().refCount(1).
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .publish()
                .refCount(1); // This method control the number of subscribers the Flux will wait before it starts emitting signals.

        movieStream.subscribe(Util.subscriber("Sam"));

        Util.sleepSeconds(10);

        movieStream.subscribe(Util.subscriber("Mike"));

        Util.sleepSeconds(30);
    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
