package com.mycompany.observer_files;

public class Observer_files {
    public static void main(String[] args) throws InterruptedException {

        // список путей на файлы за которыми мы хотим следить
        String[] pathArr = {"test_files\\test1.txt",
                            "test_files\\test2.txt",
                            "test_files\\test3.txt",
                            "test_files\\test4.txt"};

        // создаём наблюдаемого и передаём туда массив путей на файлы
        FileMonitor fileMonitor = new FileMonitor(pathArr);

        // добавляем наблюдаемому ссылку на наблюдателя
        fileMonitor.addFileObserver(FileObserverToConsole.getInstance());
        
        fileMonitor.addFile("test_files\\test5.txt");
        fileMonitor.addFile("test_files\\test6.txt");

        FileObserverToConsole.FormatPrint format = (fileData) -> {
            String msg;

            if (fileData[4] == "false")
                msg = "Удалён";
            else if(fileData[1] == "false")
                msg = "Создан";
            else if (fileData[2] != fileData[5])
                msg = "Изменился размер файла";
            else
                msg = "Изменился";

            return CowSayFormat.print(fileData[0] + " " + msg);
        };

        FileObserverToConsole.getInstance().setFormatPrint(format);

        while(true) {
            Thread.sleep(1000);   // задержка 1 секунда
            fileMonitor.checkFile();    // вызов метода проверки файлов на изменения
        }
    }
}
