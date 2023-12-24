package com.rp.sec02.helper;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {
    // This execution is synchronous and blocking.
//    public static List<String> getNames(int count) {
//        List<String> list = new ArrayList<>(count);
//        for (int n = 0; n < count; n++) {
//            list.add(getName());
//        }
//        return list;
//    }

    public static Flux<String> getNames(int count) {
        return Flux.range(0, count)
                .map(i -> getName());
    }

    private static String getName() {
        Util.sleepSeconds(3);
        return Util.faker().name().fullName();
    }
}
