package com.rp.sec01.assignment;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileService {
    public Mono<String> readFile() {
        return Mono.fromSupplier(() -> {
            File f = new File(System.getProperty("user.dir") + "/src/main/java/com/rp/sec01/assignment/name_list.txt");
            try(Scanner reader = new Scanner(f)) {
                StringBuilder builder = new StringBuilder();
                while(reader.hasNextLine()) {
                    builder.append(reader.nextLine() + "\n");
                    System.out.println("Line was read...");
                }
                System.out.println("File was read.");
                return builder.toString();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Mono<Runnable> createFile() {
        return Mono.fromRunnable(() -> {
            File f = new File(System.getProperty("user.dir") + "/src/main/java/com/rp/sec01/assignment/name_list.txt");
            try(FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/src/main/java/com/rp/sec01/assignment/name_list.txt")) {
                writer.write(Util.faker().name().fullName() + "\n" + Util.faker().name().fullName() + "\n" + Util.faker().name().fullName());
                System.out.println("File created.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Mono<Runnable> deleteFile() {
        return Mono.fromRunnable(() -> {
            File f = new File(System.getProperty("user.dir") + "/src/main/java/com/rp/sec01/assignment/name_list.txt");
            if(f.delete()) {
                System.out.println("File deleted.");
            }
            else {
                throw new RuntimeException("Failed to delete file.");
            }
        });
    }
}
