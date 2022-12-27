package com.mycompany.observer_files;
import java.util.ArrayList;

public class FileObserverToConsole implements IFileObserver {
    private static FileObserverToConsole instance;
    
    private FileObserverToConsole(){
        
    }
   
    @Override
    // вывод списка изменений файлов
    public void updateFileHandler(ArrayList<String> messagesArr) {
        for(String message: messagesArr)
            System.out.println(message);
    }
    
    public static FileObserverToConsole getInstance() {
        if(instance == null)
            return new FileObserverToConsole();
        else
            return instance;
    }
}
