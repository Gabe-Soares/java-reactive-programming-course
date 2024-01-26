package com.rp.sec09;

import com.rp.courseutil.Util;
import com.rp.sec09.helper.BookOrder;
import com.rp.sec09.helper.RevenueReport;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lec03Assignment {
    public static void main(String[] args) {
        Set<String> allowedCategories = Set.of(
                "Science Fiction",
                "Fantasy",
                "Suspense/Thriller"
        );

        bookStream()
                .filter(i -> allowedCategories.contains(i.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .map(list -> revenueCalculator(list))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(30);
    }

    private static RevenueReport revenueCalculator(List<BookOrder> orderList) {
        Map<String, Double> map = orderList.stream()
                .collect(Collectors.groupingBy(BookOrder::getCategory, Collectors.summingDouble(BookOrder::getPrice)));

        return new RevenueReport(map);
    }

    private static Flux<BookOrder> bookStream() {
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> new BookOrder());
    }
}
