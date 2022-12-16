package com.mycompany.observer_files;

import java.io.File;
import java.util.ArrayList;

public class Observer_files
{
    public static void main(String[] args)
    {
        ArrayList<FileObj> fileList = new ArrayList();
        
        FileObj fileObserv = new FileObj("D:\\test.txt");
        
        while(true)
            if(fileObserv.update())
                System.out.println(fileObserv.updateList());
        
    }
}
