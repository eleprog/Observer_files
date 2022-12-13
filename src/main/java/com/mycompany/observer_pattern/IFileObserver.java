package com.mycompany.observer_pattern;

import java.util.ArrayList;
import java.io.File;

public interface IFileObserver 
{
    void updateFileHandler(ArrayList<File> data);
}
