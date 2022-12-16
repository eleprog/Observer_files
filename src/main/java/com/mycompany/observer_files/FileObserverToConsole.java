package com.mycompany.observer_files;
import java.util.ArrayList;

public class FileObserverToConsole implements IFileObserver {

    @Override
    public void updateFileHandler(ArrayList<String> updateMessages) {
        System.out.println(updateMessages);
    }   
}
