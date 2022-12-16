package com.mycompany.observer_files;

import java.util.ArrayList;

public class ConsoleFileMonitor implements IFileMonitor
{
    private ArrayList<FileObj> fileList = new ArrayList<>();            // список объектов для работы с файлами
    private ArrayList<IFileObserver> observers = new ArrayList<>();     // список наблюдателей
    private ArrayList<String> updateFileMessage = new ArrayList<>();    // список всех изменений в файлах
    
    
     // конструктор принимающий массив путей на файлы
    ConsoleFileMonitor(){  

    }
    
    // конструктор принимающий один путь на файл
    ConsoleFileMonitor(String path){   
        fileList.add(new FileObj(path));
    }
    
    // конструктор принимающий массив путей на файлы
    ConsoleFileMonitor(String[] pathArr){   
        for(String path: pathArr)
            fileList.add(new FileObj(path));
    }
    
    // добавление файла для слежения
    public boolean addFile(String path) {   
        return fileList.add(new FileObj(path));
    }
    
    // удаление файла для слежения
    public boolean removeFile(String path) {    
        return fileList.remove(new FileObj(path));
    }
    
    @Override
    // добавление наблюдателя
    public void addFileObserver(IFileObserver Obj) {    
        observers.add(Obj);
    }

    @Override
    // удаление наблюдателя
    public void removeFileObserver(IFileObserver Obj) { 
        fileList.remove(Obj);
    }
    
    
    @Override
    // оповещение наблюдателей о событии
    public void notifyFileObserver() {      
        for(IFileObserver fileObserv: observers)
            fileObserv.updateFileHandler(updateFileMessage);
    }
    
    // проверка состояния файлов
    public void checkFile() 
    {
        boolean status = false;
        updateFileMessage.clear();
        
        for(FileObj file: fileList)
            if(file.getUpdateStatus()) {
                updateFileMessage.add(file.getUpdateMessage());
                status = true;
            }
  
        if(status) 
            this.notifyFileObserver();
    }
}
