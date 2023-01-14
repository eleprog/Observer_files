package com.mycompany.observer_files;

import java.util.ArrayList;
import java.io.File;
import java.util.List;

public interface IFileObserver 
{
    void updateFileHandler(ArrayList<FileInfo> data);

}
