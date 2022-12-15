package com.mycompany.observer_pattern;

import java.io.File;
import java.util.ArrayList;

public class Observer_files
{
    public static void main(String[] args)
    {
        ArrayList<FileObj> fileList = new ArrayList();
        
        FileObj fileObserv = new FileObj("D:\\test");
        
        while(true)
        {
            if(fileObserv.update())
                System.out.print(fileObserv.updateList());
        }
        
    }
}
