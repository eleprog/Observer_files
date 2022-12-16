package com.mycompany.observer_files;
import java.util.ArrayList;

public class FileObserverToConsole implements IFileObserver {

    @Override
    // вывод списка изменений файлов
    public void updateFileHandler(ArrayList<String> updateMessages) {
        System.out.println(updateMessages);
    }   
}
