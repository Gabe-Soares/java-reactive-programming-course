package com.rp.sec08;

import com.rp.courseutil.Util;
import com.rp.sec08.helper.NameGenerator;

public class Lec01StartWith {
    public static void main(String[] args) {
        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sub1"));

        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sub2"));

        generator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("sub3"));

        generator.generateNames()
                .filter(s -> s.startsWith("A"))
                .take(1)
                .subscribe(Util.subscriber("sub4"));
    }
}
