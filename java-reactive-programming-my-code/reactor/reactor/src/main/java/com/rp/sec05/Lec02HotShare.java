package com.rp.sec05;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec02HotShare {
    public static void main(String[] args) {
        // The hot publisher behaviour is to emit data independent of the subscriber, sharing the stream of signals with the multiple subscribers.
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .share(); // share() method converts a cold publisher into a hot publisher by multicasting the content.

        movieStream.subscribe(Util.subscriber("Sam"));

        Util.sleepSeconds(5);

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
