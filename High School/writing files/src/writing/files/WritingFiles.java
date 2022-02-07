package writing.files;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WritingFiles {

    private static PrintWriter writer;
    
    public static void main(String[] args) {
        File somethingTest = new File("somethingTest/hi");
        somethingTest.mkdirs();
        
        File f = new File("someThingTest/hi/text");
        
        if(!f.exists()){
        try {
            writer = new PrintWriter("somethingTest/hi/text", "UTF-8");
            writer.println("The PWs:");
            writer.println("secan");
            writer.close();
            
            
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(WritingFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
        
            
        }
    }
    

