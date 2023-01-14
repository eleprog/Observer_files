package com.mycompany.observer_files;

import java.util.Date;

public class FileInfo {
    String  path;
    boolean existOld;
    boolean exist;
    long    lastModifyOld;
    long    lastModify;
    long    sizeOld;
    long    size;

    FileInfo() {}

    @Override
    public String toString() {
        return  "путь: " + path + "\n" +
                "существует: " + exist + "\n" +
                "предыдущая последняя модификация: " + new Date(lastModifyOld) + "\n" +
                "последняя модификация: " + new Date(lastModify) + "\n" +
                "предыдущий размер: " + sizeOld + " байт(а)\n" +
                "размер: " + size + " байт(а)";
    }
}
