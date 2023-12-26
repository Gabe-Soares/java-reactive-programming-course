package com.rp.sec03.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileServiceFlux {
    private Callable<Scanner> openFile(Path path){
        return () -> {
            try {
                return new Scanner(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private BiFunction<Scanner, SynchronousSink<String>, Scanner> readLines() {
        return (s, sink) -> {
            if(s.hasNextLine()) {
                sink.next(s.nextLine() + "\n");
            }
            else {
                sink.complete();
            }
            return s;
        };
    }

    private Consumer<Scanner> closeScanner() {
        return (Scanner s) -> {
            s.close();
        };
    }

    public Flux readFile(Path path) {
        return Flux.generate(openFile(path),
                readLines(),
                closeScanner());
    }
}
