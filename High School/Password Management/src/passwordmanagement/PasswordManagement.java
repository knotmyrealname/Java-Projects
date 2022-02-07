package passwordmanagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;



public class PasswordManagement {

    
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, FileNotFoundException, IOException {
        
        LoginScreen login = new LoginScreen("Test", 180, 300);
            login.createLoginPanel();
            login.createLoginButtons();
            
            login.init();
            
//            Encryptor e = new Encryptor();
//                byte[] salt = e.generateSalt();
//                byte[] e1;
//                
//                String saltString = new String(salt);
//                    System.out.println(saltString);
//                byte[] saltStringed = saltString.getBytes();
//                    System.out.println(Arrays.toString(saltStringed));
//                    
//        try (                    for (int x = 0; x <salt.length; x++){
//                        int x1 = x;
//                        System.out.println();
//                    }
//                PrintWriter write = new PrintWriter(new File("src/mtsc.txt"), "UTF-8")) 
//        {
//            e1 = e.Encrypt("few", salt);
//            String printedString = ("Username" + " : " + Arrays.toString(salt) + " : " + Arrays.toString(e1));
//            write.println(printedString);
//            String secondprintedString = ("fois" + "1230");
//            write.println(secondprintedString);
//        }
//            int st = salt[1];
//        System.out.println(st);
//                System.out.println(salt + "  " + e1);
//                System.out.println(Arrays.toString(salt) + "  " + Arrays.toString(e1));
//                System.out.println((new String(salt))+ "  " + (new String(e1))); 
//                
//                //BufferedReader reader = new BufferedReader(new FileReader("src/mtsc.txt"));
//                File scanFile = new File("src/mtsc.txt");
//                Scanner scanner = new Scanner(scanFile);
//                List<String> list = new ArrayList<>();
//                while (scanner.hasNextLine()){
//                    String nextLine = scanner.nextLine().trim();
//                    if ("Username".equals(nextLine)){
//                        System.out.println("yes");
//                        break;
//                    }
//                    else {
//                        System.out.println("no");
//                        System.out.println(nextLine);
//                    }
//                }
//                
//                //System.out.println(Arrays.toString(pwString.getBytes()));
//            
//            
            
    }
    
}
