package passwordmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


public class LoginTester {
    
    private byte[] reference = new byte[8], salt;
    private static boolean authenticate;
    private Encryptor e = new Encryptor();
    
    public boolean loginTest(String filepath) throws FileNotFoundException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException{
        authenticate = false;
        
        LoginScreen ls = new LoginScreen();
            String Pw = ls.getPass();
            String User = ls.getUser();
            File file = new File(filepath);
        
        TextStore txtS = new TextStore();
        salt = txtS.searchForSalt(file, User);
        authenticate = salt != reference;
        
        
        authenticate = txtS.comparePWs(file, User, e.Encrypt(Pw, salt), salt);
            
        return authenticate;
    }
    
    public byte[] getSalt(){
        return salt;
    }
    
    
}
