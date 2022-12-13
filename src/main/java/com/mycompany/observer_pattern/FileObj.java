package com.mycompany.observer_pattern;

import java.io.File;

public class FileObj 
{
    File fileObj;
    String filePath;
    long fileLastUpdate;
    long fileLength;
    boolean fileExist;
    
    FileObj(String path) {
        
        filePath = path;
        exists();
        length();
        lastUpdate();       
    }
    
    void updated()
    {
        
        
    }
    
    private void exists()
    {
        
        
    }
    
    private void length()
    {
        
              
    }
    
    private void lastUpdate()
    {
        
               
    }   
}
