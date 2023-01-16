package com.mycompany.observer_files;

import java.util.Date;

public class Observer_files {
    public static void main(String[] args) throws InterruptedException {

        String[] pathArr = {"test_files\\test1.txt",    // список путей на файлы за которыми мы хотим следить
                            "test_files\\test2.txt",
                            "test_files\\test3.txt",
                            "test_files\\test4.txt"};

        ConsoleFileMonitor fileMonitor = new ConsoleFileMonitor(pathArr);   // создаём наблюдаемого и передаём туда массив путей на файлы
        fileMonitor.addFileObserver(FileObserverToConsole.getInstance());   // добавляем наблюдаемому ссылку на наблюдателя
        
        fileMonitor.addFile("test_files\\test5.txt");
        fileMonitor.addFile("test_files\\test6.txt");

        FormatPrintFilesModification format = (fileData) -> {
            String msg;

            if (!fileData.exist)
                msg = "Удалён";
            else if(!fileData.existOld)
                msg = "Создан";
            else if (fileData.sizeOld != fileData.size)
                msg = "Изменился размер файла";
            else
                msg = "Изменился";

            return CowSayFormat.print(fileData.path + " " + msg);
        };

        FileObserverToConsole.getInstance().setFormatPrint(format);

        while(true) {
            Thread.sleep(1000);   // задержка 1 секунда
            fileMonitor.checkFile();    // вызов метода проверки файлов на изменения
        }
    }
}
