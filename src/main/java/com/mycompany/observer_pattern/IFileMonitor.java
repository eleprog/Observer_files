package com.mycompany.observer_pattern;

public interface IFileMonitor 
{
    void addFileObserver(IFileObserver Obj);
    void removeFileObserver(IFileObserver Obj);
    void notifyFileObserver();
}
