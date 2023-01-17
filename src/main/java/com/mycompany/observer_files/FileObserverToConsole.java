package com.mycompany.observer_files;
import java.util.ArrayList;

public class FileObserverToConsole implements IFileObserver {
    static FileObserverToConsole instance;


    public interface FormatPrint {
        String print(String[] fileData);
    }

    /**
     * формат вывода по умолчанию
     */
    static private FormatPrint formatPrint = (fileData) -> {
        String strOut = "";

        if(fileData != null)
            for(String str: fileData)
                strOut += str + " ";

        return strOut;
    };

    /**
     * конструктор private для singletone
     */
    private FileObserverToConsole() {}

    /**
     * вывод списка изменений файлов
     */
    @Override
    public void updateFileHandler(ArrayList<String[]> MessagesArr) {
        for(String[] info: MessagesArr) {
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


