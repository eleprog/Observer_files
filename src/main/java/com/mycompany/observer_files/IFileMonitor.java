package com.mycompany.observer_files;

public interface IFileMonitor 
{
    void addFileObserver(IFileObserver Obj);
    void removeFileObserver(IFileObserver Obj);
    void notifyFileObserver();
}
