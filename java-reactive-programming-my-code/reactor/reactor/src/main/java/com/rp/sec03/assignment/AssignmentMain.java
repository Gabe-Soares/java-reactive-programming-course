package com.rp.sec03.assignment;

import com.rp.courseutil.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AssignmentMain {
    public static void main(String[] args) {
        FileServiceFlux service = new FileServiceFlux();

        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");

        service.readFile(path)
                .subscribe(Util.subscriber());
    }
}
