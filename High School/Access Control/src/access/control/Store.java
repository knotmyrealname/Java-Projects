package access.control;

import java.io.File;


public class Store {
    
    //creates a folder with the specified directory, and creates new directories if they had not existed previously
    public void createFolder(String total_path_name){
        File folder = new File(total_path_name);
            folder.mkdirs();
    }
    //creates a text document of which is to be edited by
    public void createTextDocument(String total_path_name){
        File file = new File(total_path_name);
        
    }
    
}
