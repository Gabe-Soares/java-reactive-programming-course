package com.rp.sec05;

import com.rp.courseutil.Util;
import com.rp.sec05.assignment.OrderService;
import com.rp.sec05.assignment.InventoryService;
import com.rp.sec05.assignment.RevenueService;

public class Lec06Assignment {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        revenueService.revenueStream().subscribe(Util.subscriber("Revenue - "));
        inventoryService.inventoryStream().subscribe(Util.subscriber("Inventory - "));

        Util.sleepSeconds(60);
    }
}
