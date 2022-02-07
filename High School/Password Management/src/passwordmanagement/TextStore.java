package passwordmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;


public class TextStore {
    
    private static PrintWriter writer;
    private static boolean identical;
    
    public void appendToFile(){
        
    }
    
    public void createTextDocument(String filepath) throws FileNotFoundException, UnsupportedEncodingException{
        File f = new File(filepath);
        if(!f.exists()){
        writer = new PrintWriter(filepath, "UTF-8");
        }
        
    }
    
    public byte[] searchForSalt(File f, String username) throws FileNotFoundException, UnsupportedEncodingException{
        Scanner scanner = new Scanner(f);
        byte[] salt = new byte[8];
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.substring(0, username.length()).contains(username)){
               String saltString = line.substring(username.length() + 4, line.lastIndexOf(":") - 2);
               for(int x = 0; x < 7; x++){
                   String s = saltString.substring(saltString.lastIndexOf(",") + 2, saltString.length());
                   salt[7-x] = Byte.parseByte(s);
                   saltString = saltString.substring(0, saltString.lastIndexOf(","));
               }
               salt[0] = Byte.parseByte(saltString.substring(0, saltString.length()));
            }
        }
        
        return salt;
    }
    
    public void addToTextDocument(String filepath, String username, byte[] encryptedPW, byte[] salt) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw = new PrintWriter(new File(filepath), "UTF-8");
            pw.println(username + " : " + Arrays.toString(salt) + " : " + Arrays.toString(encryptedPW));
            pw.close();
        
    }
    
    public void createFolder(String filepath){
        
        File folderCreate = new File(filepath);
            folderCreate.mkdirs();
    }
    public boolean comparePWs(File filepath, String username, byte[] encryptedPW, byte[] salt) throws FileNotFoundException{
        identical = false;
        String formattedString = username + " : " + Arrays.toString(salt) + " : " + Arrays.toString(encryptedPW);
        Scanner scanner = new Scanner(filepath);
        while(scanner.hasNextLine()){
            String nextLine = scanner.nextLine();
            identical = nextLine.contains(formattedString);
            System.out.println(nextLine);
            System.out.println(formattedString);
            System.out.println(identical);
        }
        
        return identical;
    }
    
}
