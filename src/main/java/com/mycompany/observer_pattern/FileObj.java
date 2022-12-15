package com.mycompany.observer_pattern;

import java.io.File;
import java.util.ArrayList;

public class FileObj 
{
    File fileObj;
    String filePath;
    long fileLastUpdate;
    long fileLength;
    boolean fileExist;
    ArrayList<String> fileUpdateBuff;
    
    FileObj(String path) {
        
        filePath = path;
        fileObj = new File(path);
        fileExist = fileObj.exists();
        
        
        //length();
        //lastUpdate();
    }
    
    boolean update()
    {
        boolean status = false;
        
        boolean tmp = fileObj.exists();
        if(tmp != fileExist)
        {              
            if(tmp)
                fileUpdateBuff.add("Файл появился");
            else
                fileUpdateBuff.add("Файл исчез");
            
            status = true;
        } 
        return status;
    }
    
    ArrayList<String> updateList()
    {
        ArrayList<String> tmp = fileUpdateBuff;
        fileUpdateBuff.clear();
        return tmp;
    }
    
    
    private boolean exists() {
        return fileObj.exists() != fileExist;
    }
    
    private void length()
    {
        
              
    }
    
    private void lastUpdate()
    {
        
               
    }        
}
