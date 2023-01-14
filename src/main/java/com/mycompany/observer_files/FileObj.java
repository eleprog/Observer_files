package com.mycompany.observer_files;

import java.io.File;

public class FileObj {

    private final String filePath;
    private final File fileObj;   

    private long fileLastModify;
    private long fileSize;
    private boolean fileExist;


    // конструктор принимающий путь на файл
    FileObj(String path) {
        filePath = path;
        fileObj  = new File(path);

        fileInfoUpdate();
    }
    
    // получение статуса файла (обновлен или нет)
    public boolean getUpdateStatus() {
        if(fileObj.lastModified() != fileLastModify) {
            return true;
        }
        return false;
    }

    /** получение информации о файле filePath; fileSize(old); fileLastModify(old); fileSize; fileExist
     *
     * @return структура данных о файле с полями: path, sizeOld, size, lastModifyOld, lastModify, exist
     */
    FileInfo getFileInfo() {
        FileInfo data = new FileInfo();

        data.path = filePath;
        data.existOld = fileExist;
        data.sizeOld = fileSize;
        data.lastModifyOld = fileLastModify;

        fileInfoUpdate();
        data.lastModify = fileLastModify;
        data.size = fileSize;
        data.exist = fileExist;

        return data;
    }

    // обновление данных о файле
    private void fileInfoUpdate() {
        fileExist       = fileObj.exists();
        fileLastModify  = fileObj.lastModified();
        fileSize        = fileObj.length();
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