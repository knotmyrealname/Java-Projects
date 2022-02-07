package passwordmanagement;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;

public class Encryptor {
    
    
    
    public byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        
        byte[] salt = new byte[8]; //generates 8 byte salt
        random.nextBytes(salt);
        
        return salt;
    }
    
    public boolean authenticate(String inputPW, byte[] encryptedPW, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
        
        byte[] encryptedInputPW = Encrypt(inputPW, salt);
        
        return Arrays.equals(encryptedPW, encryptedInputPW);
        
    }
    
    public byte[] Encrypt(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException{
        
        String algorithm = "PBKDF2WithHmacSHA1";
        int derivedKeyLength = 160;
        int iterations = 1293801;
        
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);
        SecretKeyFactory f = SecretKeyFactory.getInstance(algorithm);
        
        return f.generateSecret(spec).getEncoded();
        
    }
}
