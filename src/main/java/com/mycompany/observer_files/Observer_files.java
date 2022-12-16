package com.mycompany.observer_files;

public class Observer_files
{
    public static void main(String[] args) throws InterruptedException
    {
        String[] pathArr = {"test_files\\test1.txt",    // список путей на файлы за которыми мы хотим следить
                            "test_files\\test2.txt",
                            "test_files\\test3.txt",
                            "test_files\\test4.txt"};
              
        FileObserverToConsole observerToConsole = new FileObserverToConsole();  //создаём объект наблюдателя печатающего в консоль
        
        ConsoleFileMonitor fileMonitor = new ConsoleFileMonitor(pathArr);       // создаём наблюдаемого и передаём туда массив путей на файлы
        fileMonitor.addFileObserver(observerToConsole);                     // добавляем наблюдаемому ссылку на наблюдателя
        
        fileMonitor.addFile("test_files\\test5.txt");
        fileMonitor.addFile("test_files\\test6.txt");
        
        while(true)
        {
            Thread.sleep(1000);   // задержка 1 секунда
            fileMonitor.checkFile();    // вызов метода проверки файлов на изменения
        }
    }
}
