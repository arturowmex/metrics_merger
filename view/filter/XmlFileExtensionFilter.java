/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.filter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Arturo
 */
public class XmlFileExtensionFilter extends FileFilter{

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
 
        String extension = getExtension(file);
        if (extension != null) {
            return extension.toLowerCase().equals("xml");
        }
 
        return false;
    }
    

    private String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

    @Override
    public String getDescription() {
        return "Xml cobertura files";
    }
    
}
