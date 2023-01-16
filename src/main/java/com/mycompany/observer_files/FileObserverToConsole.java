package com.mycompany.observer_files;
import java.util.ArrayList;
import java.util.Date;

public class FileObserverToConsole implements IFileObserver {
    static FileObserverToConsole instance;


    public interface FormatPrint {
        String print(FileInfo fileData);
    }

    /**
     * формат вывода по умолчанию
     */
    static private FormatPrint formatPrint = (fileData) -> {
        String msg;

        if (!fileData.exist)
            msg = "Удалён";
        else if(!fileData.existOld)
            msg = "Создан";
        else if (fileData.sizeOld != fileData.size)
            msg = "Изменился размер файла";
        else
            msg = "Изменился";

        return new Date() + " | " + fileData.path + " " + msg;
    };


    /**
     * конструктор private для singletone
     */
    private FileObserverToConsole() {}

    /**
     * вывод списка изменений файлов
     */
    @Override
    public void updateFileHandler(ArrayList<FileInfo> MessagesArr) {
        for(FileInfo info: MessagesArr) {
            System.out.println(formatPrint.print(info));
        }
    }

    /**
     * установка формата вывода
     */
    public void setFormatPrint(FormatPrint format) {
        formatPrint = format;
    }

    /**
     * глобальная точка доступа к объекту
     */
    public static FileObserverToConsole getInstance() {
        if(instance == null)
            instance = new FileObserverToConsole();
        return instance;
    }
}


