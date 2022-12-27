package com.mycompany.observer_files;

public interface IFileMonitor 
{
    boolean addFileObserver(IFileObserver Obj);
    void removeFileObserver(IFileObserver Obj);
    void notifyFileObserver();
}
