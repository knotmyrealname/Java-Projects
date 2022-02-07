package access.control;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

@SuppressWarnings("MismatchedReadAndWriteOfArray")
public class Authentication {
    
    public String mc_string = "ilikeminecraft";
    public byte[] mc_salt = {-96, 36, 77, 92, 85, 47, 16, -7};
    public byte[] mc_pw = {35, -8, 122, -93, -36, 36, -116, -72, -43, 12, -37, -108, -46, -4, 76, 26, -105, 96, -127, 72};
    
    //generates a salt for the password
    public byte[] moarSalt() throws NoSuchAlgorithmException{
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        
        byte[] salt = new byte[8];
            random.nextBytes(salt);
        return salt;
    }
    
    //checks if the password given matches the original password
    public boolean authenticate(String password,byte[] encryptedPW, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
        
        byte[] inputPW = hacerLeEncrypt(password, salt);
        
        return Arrays.equals(inputPW, encryptedPW );
    }
    //encrypts a password, given a salt and a password
    public byte[] hacerLeEncrypt(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
        String algorithm = "PBKDF2WithHmacSHA1";
        int keylength = 160;
        int how_much_insanity = 1092389;
        
        KeySpec keyspec = new PBEKeySpec(password.toCharArray(), salt, how_much_insanity, keylength);
        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);
        
        return f.generateSecret(keyspec).getEncoded();
    }
    
    public String formatPassword(String username, byte[] salt, byte[] encrypted_password){
        String formatted = username + "  " + Arrays.toString(salt) + "  " + Arrays.toString(encrypted_password);
        return formatted;
        
    }
    
    public void changePassword(String OldPassword, String username, String NewPassword){
        
    }
    
    
}
