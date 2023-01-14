package com.mycompany.observer_files;

import java.util.ArrayList;

public class ConsoleFileMonitor implements IFileMonitor
{
    private ArrayList<FileObj> fileList = new ArrayList<>();            // список объектов для работы с файлами
    private ArrayList<IFileObserver> observers = new ArrayList<>();     // список наблюдателей
    private ArrayList<FileInfo> fileUpdatesList = new ArrayList<>();    // список всех изменений в файлах
    
    
     // конструктор создающий объект класса ConsoleFileMonitor
    ConsoleFileMonitor(){ }
    
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
        FileObj fileObj = new FileObj(path);
        
        if(fileList.lastIndexOf(fileObj) == -1) {
            fileList.add(fileObj);
            return true;
        }
        else
            return false;
    }
    
    // удаление файла для слежения
    public boolean removeFile(String path) {
        return fileList.remove(new FileObj(path));
    }

    // добавление наблюдателя
    @Override
    public boolean addFileObserver(IFileObserver Obj) {
        if(Obj == null)
            return false;

        for(IFileObserver observ: observers)
            if(observ == Obj)
                return false;

        observers.add(Obj);
        return true;
    }

    // удаление наблюдателя
    @Override
    public boolean removeFileObserver(IFileObserver Obj) {
        if(Obj == null)
            return false;

        return fileList.remove(Obj);
    }

    // оповещение наблюдателей о событии
    @Override
    public void notifyFileObserver() {      
        for(IFileObserver fileObserv: observers)
            fileObserv.updateFileHandler(fileUpdatesList);
    }
    
    // проверка состояния файлов
    public void checkFile() 
    {
        boolean status = false;
        fileUpdatesList.clear();
        
        for(FileObj file: fileList)
            if(file.getUpdateStatus()) {
                fileUpdatesList.add(file.getFileInfo());
                status = true;
            }
  
        if(status) 
            this.notifyFileObserver();
    }
}
