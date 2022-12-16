package com.mycompany.observer_files;

import java.io.File;
import java.util.ArrayList;

public class FileObj 
{
    private String filePath;
    private File fileObj;   
    private long fileLastUpdate;
    private long fileSize;
    private boolean fileExist;
    private String fileUpdateMessage;
     
    FileObj(String path) {       
        filePath = path;
        fileObj = new File(path);
        
        fileExist = fileObj.exists();
        fileLastUpdate = fileObj.lastModified();
        fileSize = fileObj.length();
    }
    
    boolean getUpdateStatus() {
        boolean status = false;          
        boolean tmpExist = fileObj.exists();
        
        if(tmpExist != fileExist) {
            if(tmpExist)
                fileUpdateMessage = "Файл " + fileObj.getName() + " создан";
            else
                fileUpdateMessage = "Файл " + fileObj.getName() + " удалён";
            fileExist = tmpExist;
            status = true;     
        }
        
        if(tmpExist) {
            long tmpLastUpdate = fileObj.lastModified();
            long tmpSize = fileObj.length();

            if(tmpLastUpdate != fileLastUpdate) {
                fileLastUpdate = tmpLastUpdate;

                if(tmpSize != fileSize) {
                    fileUpdateMessage = "Файл " + fileObj.getName() + " модифицирован: изменён размер (" + fileSize + " байт  ->  " + tmpSize + " байт)";
                    fileSize = tmpSize;
                }
                else
                    fileUpdateMessage = "Файл " + fileObj.getName() + " модифицирован";
                
                status = true;
            }
        }
        
        return status;
    }
    
    String getUpdateMessage()
    {
        String tmp = fileUpdateMessage;
        fileUpdateMessage = " ";
        return tmp;
    }
    
    String getFilePath(){
        return filePath;
    }
    
    @Override
    public boolean equals(Object Obj) {
        return Obj instanceof FileObj && filePath.equals(((FileObj)Obj).getFilePath());
    }
    
}
