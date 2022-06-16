/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.fernwebsites.storagefinder;

//import com.formdev.flatlaf.FlatLightLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author brand
 */
public class StorageFinder {

    public static void main(String[] args) {
        //Main-Class: com.fernwebsites.storagefinder.StorageFinder
        
        try {
//            javax.swing.plaf.metal.MetalLookAndFeel
//            javax.swing.plaf.nimbus.NimbusLookAndFeel
//            com.sun.java.swing.plaf.motif.MotifLookAndFeel
//            com.sun.java.swing.plaf.windows.WindowsLookAndFeel
//            com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//            UIManager.getSystemLookAndFeelClassName()
//            UIManager.getCrossPlatformLookAndFeelClassName()
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            Logger.getLogger(StorageFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultList resultList = new ResultList();
        resultList.setLocationRelativeTo(null);  
        resultList.setVisible(true);
        
        
        
        
    }
}
