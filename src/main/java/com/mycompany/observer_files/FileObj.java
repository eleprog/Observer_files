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
        return fileObj.lastModified() != fileLastModify;
    }

    /** получение информации о файле filePath; fileSize(old); fileLastModify(old); fileSize; fileExist
     *
     * @return [0] - filePath, [1] - existOld, [2] - sizeOld, [3] - lastModifyOld,
     * [4] - exist, [5] - size, [6] - lastModify
     */
    String[] getFileInfo() {
        String[] data = new String[7];

        data[0] = filePath;
        data[1] = String.valueOf(fileExist);
        data[2] = String.valueOf(fileSize);
        data[3] = String.valueOf(fileLastModify);
        fileInfoUpdate();

        data[4] = String.valueOf(fileExist);
        data[5] = String.valueOf(fileSize);
        data[6] = String.valueOf(fileLastModify);

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