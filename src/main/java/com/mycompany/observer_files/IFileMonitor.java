package com.mycompany.observer_files;

public interface IFileMonitor {
    boolean addFileObserver(IFileObserver Obj);
    boolean removeFileObserver(IFileObserver Obj);
    void notifyFileObserver();
}
