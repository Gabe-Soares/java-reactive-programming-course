package com.rp.sec04;

import com.rp.courseutil.Util;
import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.UserService;

public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId())) // If the return is Mono or Flux, it's very likely you would want to use flatMap.
//                .filter(purchaseOrder -> purchaseOrder.getUserId() > 1)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
