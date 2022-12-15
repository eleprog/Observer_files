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
    ArrayList<String> fileUpdateBuff = new ArrayList<>();
    
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
        
        long tmp = fileObj.length();
        if(tmp != fileLength)
        {              
            //if(tmp)
                fileUpdateBuff.add("Файл обновился " + tmp + " Байт");
            //else
                //fileUpdateBuff.add("Файл исчез");
            fileLength = tmp;
            status = true;
            
        } 
        return status;
    }
    
    ArrayList<String> updateList()
    {
        ArrayList<String> tmp = new ArrayList<>(fileUpdateBuff);
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
