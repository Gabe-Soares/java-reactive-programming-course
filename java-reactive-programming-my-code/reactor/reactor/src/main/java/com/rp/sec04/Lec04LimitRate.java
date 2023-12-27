package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 100)
                .log()
                .limitRate(10, 0) // The lowTide parameter is a way of controlling the percentage os the data that should be processed for the subscriber before making the next request. The lowTide of value 0 is equivalent to 100% of the data processed before another request.
                .subscribe(Util.subscriber());
    }
}
