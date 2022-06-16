/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernwebsites.storagefinder.FileUtils;

import com.fernwebsites.storagefinder.LoadingPopUp;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author brand
 */
public class FileUtil {
    
    
    
    
    
    public static List<FileData> exploreFile(File file, int depth, int indicatorDepth, LoadingPopUp loadingScreen) {
        List<FileData> allFiles = new ArrayList<>();
        
        // go through all the children and add to all files and immediateChildren
        List<File> children = Arrays.asList(file.listFiles());
        List<FileData> immediateChildren = new ArrayList<>();
        for (File cf : children){
            try{
                if (Files.isDirectory(cf.toPath())) {
                    //recursive call
                    List<FileData> explored = exploreFile(cf, depth + 1, indicatorDepth, loadingScreen);
                    allFiles.addAll(explored);
                    immediateChildren.add(explored.get(explored.size() - 1));
                } else {
                    //if it's not a directory make a add to all files and immediatechildren and get the size
                    allFiles.add(new FileData(Files.size(cf.toPath()), cf.toPath(), new ArrayList<>()));
                    immediateChildren.add(new FileData(Files.size(cf.toPath()), cf.toPath(), new ArrayList<>()));
                }
            } catch(Exception e) {
                System.out.println("Couldn't Access: " + cf.getAbsolutePath());
            }
        }
        
        //add a filedata for this file and to end of allFiles to be accessed after recursive call
        long size = immediateChildren.stream().mapToLong(FileData::getSize).sum();
        allFiles.add(new FileData(size, file.toPath(), immediateChildren));
        
        if (depth + 1 == indicatorDepth) {
            loadingScreen.incrementProgressBar(immediateChildren.size());
        }
        
        
        return allFiles;
    } 
    
    
    public static int[] getIndicatorDepth(File file, int desiredIndicatorSize) {
        int currentDepth = 1;
        List<File> currentDepthChildren = new ArrayList<>();
        currentDepthChildren.addAll(Arrays.asList(file.listFiles()));
        
        while(currentDepthChildren.size() < desiredIndicatorSize) {
            List<File> nextDepthChildren = new ArrayList<>();
            for (File f : currentDepthChildren) {
                if (Files.isDirectory(f.toPath())){
                    File[] files = f.listFiles();
                    if (files != null) {
                        nextDepthChildren.addAll(Arrays.asList(files));
                    }
                }
                
            }
            
            currentDepthChildren = nextDepthChildren;
            currentDepth++;
        }
        System.out.println(currentDepth);
        return new int[]{currentDepth, currentDepthChildren.size()};
    }
    
    public static float getGB(long l) {
        return ((float) l)/ 1000000000;
    }
    
    public static String getGBAsString(long l, int length) {
        String ret = String.format("%.2f", getGB(l)) + "GB";
        while (ret.length() < length) {
            ret += " ";
        }
        return ret;
    }
    
}
