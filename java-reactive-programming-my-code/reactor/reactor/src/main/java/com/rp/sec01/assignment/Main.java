package com.rp.sec01.assignment;

import com.rp.courseutil.Util;

public class Main {
    public static void main(String[] args) {
        FileService fs = new FileService();

        var monoCreateFile = fs.createFile();
        monoCreateFile.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        fs.readFile().subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

        fs.deleteFile().subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
