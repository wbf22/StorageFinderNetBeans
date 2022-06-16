/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernwebsites.storagefinder.FileUtils;

import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author brand
 */
public class FileData {
    
    private long size;
    private Path path;
    private List<FileData> immediateChildren;

    public FileData(long size, Path path, List<FileData> immediateChildren) {
        this.size = size;
        this.path = path;
        this.immediateChildren = immediateChildren;
    }

    public long getSize() {
        return size;
    }

    public Path getPath() {
        return path;
    }

    public List<FileData> getImmediateChildren() {
        return immediateChildren;
    }

    
    
}
