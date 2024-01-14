package com.rp.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Objects;

public class OrderService {
    private Flux<PurchaseOrder> flux;

    public Flux<PurchaseOrder> orderStream() {
        if(Objects.isNull(flux))
            flux=getPurchasedOrders();
        return flux;
    }
    private Flux<PurchaseOrder> getPurchasedOrders() {
        return Flux.interval(Duration.ofMillis(500))
                .map(i -> new PurchaseOrder())
                .publish()
                .refCount(2);
    }
}
