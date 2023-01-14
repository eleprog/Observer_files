package com.mycompany.observer_files;
import java.util.ArrayList;
import java.util.Date;

public class FileObserverToConsole implements IFileObserver {

    static FileObserverToConsole instance;

    static private FormatPrintFilesModification formatPrint = (fileData) -> {
        String msg;

        if(!fileData.exist)
            msg = "удалён";
        else if (fileData.sizeOld != fileData.size && fileData.lastModify > fileData.lastModifyOld)
            msg = "изменился размер файла (" + fileData.sizeOld + " -> " + fileData.size + ")";
        else
            msg = "изменился";

        return new Date() + " | " + fileData.path + " " + msg;
    };

    private FileObserverToConsole() {

    }

    // вывод списка изменений файлов
    @Override
    public void updateFileHandler(ArrayList<FileInfo> MessagesArr) {
        for(FileInfo info: MessagesArr) {
            System.out.println(formatPrint.print(info));
        }
    }

    // установка формата вывода
    public void setFormatPrint(FormatPrintFilesModification format) {
        formatPrint = format;
    }

    public FormatPrintFilesModification getFormatPrint() {
        return formatPrint;
    }

    // глобальная точка доступа к объекту
    public static FileObserverToConsole getInstance() {
        if(instance == null)
            instance = new FileObserverToConsole();
        return instance;
    }
}

interface FormatPrintFilesModification {
    String print(FileInfo fileData);
}
