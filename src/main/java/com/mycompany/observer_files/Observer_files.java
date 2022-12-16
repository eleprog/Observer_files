package com.mycompany.observer_files;

import java.io.File;
import java.util.ArrayList;

public class Observer_files
{
    public static void main(String[] args) throws InterruptedException
    {
        String[] pathArr = {"test1.txt",
                            "test2.txt",
                            "test3.txt",
                            "test4.txt",
                            "test5.txt",
                            "test6.txt"};
        
        ConsoleFileMonitor fileMonitor = new ConsoleFileMonitor(pathArr);
        
        while(true)
        {
            Thread.sleep(1000);
            fileMonitor.checkFile();              
        }
    }
}
