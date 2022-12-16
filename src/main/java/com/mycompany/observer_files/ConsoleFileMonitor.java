package com.mycompany.observer_files;

import java.util.ArrayList;

public class ConsoleFileMonitor implements IFileMonitor
{
    ArrayList<FileObj> fileList;
    ArrayList<IFileObserver> observers;
    ArrayList<String> updateFileMessage;
    
    ConsoleFileMonitor(String[] pathArr){
        for(String path: pathArr)
            fileList.add(new FileObj(path));
    }
                      
    public boolean addFile(String path) {
        return fileList.add(new FileObj(path));
    }
    
    public boolean removeFile(String path) {
        return fileList.remove(new FileObj(path));
    }
    
    @Override
    public void addFileObserver(IFileObserver Obj) {
        observers.add(Obj);
    }

    @Override
    public void removeFileObserver(IFileObserver Obj) {
        fileList.remove(Obj);
    }
    
    @Override
    public void notifyFileObserver() {
        for(IFileObserver fileObserv: observers)
            fileObserv.updateFileHandler(updateFileMessage);
    }
    
    public void checkFile()
    {
        boolean status = false;
        updateFileMessage.clear();
        
        for(FileObj file: fileList)
            if(file.getUpdateStatus())
                updateFileMessage.add(file.getUpdateMessage());
  
        this.notifyFileObserver();
    }
}
