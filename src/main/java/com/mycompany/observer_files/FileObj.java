package com.mycompany.observer_files;

import java.io.File;
import java.util.Date;

public class FileObj 
{
    private final String filePath;
    private final File fileObj;   
    
    private long fileLastUpdate;
    private long fileSize;
    private boolean fileExist;
    private String fileUpdateMessage;
     
    // конструктор принимающий путь на файл
    FileObj(String path) {
        filePath = path;
        fileObj  = new File(path);
        
        fileExist       = fileObj.exists();
        fileLastUpdate  = fileObj.lastModified();
        fileSize        = fileObj.length();
    }
    
    // получение статуса файла (обновлен или нет)
    // формирование сообщения о том, что именно изменилось в файле
    public boolean getUpdateStatus() {
        boolean status = false;          
        boolean tmpExist = fileObj.exists();
        
        if(tmpExist != fileExist) {
            if(tmpExist)
                fileUpdateMessage = new Date() + " Файл " + fileObj.getName() + " создан";
            else
                fileUpdateMessage = new Date() + " Файл " + fileObj.getName() + " удалён";
            fileExist = tmpExist;
            status = true;     
        }
        
        if(tmpExist) {
            long tmpLastUpdate = fileObj.lastModified();
            long tmpSize = fileObj.length();

            if(tmpLastUpdate != fileLastUpdate) {
                fileLastUpdate = tmpLastUpdate;

                if(tmpSize != fileSize) {
                    fileUpdateMessage = new Date(fileLastUpdate) + " Файл " + fileObj.getName() + " модифицирован: изменён размер (" + fileSize + " байт  ->  " + tmpSize + " байт)";
                    fileSize = tmpSize;
                }
                else
                    fileUpdateMessage = new Date(fileLastUpdate) + " Файл " + fileObj.getName() + " модифицирован";
                
                status = true;
            }
        }
        
        return status;
    }
    
    // получение сообщения о изменении файла
    String getUpdateMessage() {
        return fileUpdateMessage;
    }
    
    // получение ссылки на файл
    String getFilePath() {
        return filePath;
    }
    
    @Override
    public boolean equals(Object Obj) {
        return Obj instanceof FileObj && filePath.equals(((FileObj)Obj).getFilePath());
    }
    
}
