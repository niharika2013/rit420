package DataLayer;
//Take password, run through hash function 
//Send hashed string to database
//Encrypt password inputs to test against database
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
 
/**
 * Taken from http://www.mkyong.com/java/jce-encryption-data-encryption-standard-des-tutorial/
 *
 * @author owen
 */
public class JEncryption
{    
        static Cipher desCipher;
        static SecretKey myDesKey;
        
        
        
        /**
         * 
         */
        public JEncryption(){
            try{   
                KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		myDesKey = keygenerator.generateKey();
 
		// Create the cipher 
		desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
 
		// Initialize the cipher for encryption
		desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            }catch(  NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e){
			e.printStackTrace();
		}
        }
        
        
        
        
        /**
         * 
         * @param text
         * @return 
         */
        public byte[] encrypt(String text){
            //sensitive information
            try{
                    byte[] byteText = text.getBytes();
 
		    System.out.println("Text [Byte Format] : " + text);
		    System.out.println("Text : " + new String(text));
 
		    // Encrypt the text
		    byte[] byteEncrypted = desCipher.doFinal(byteText);
 
		    System.out.println("Text Encryted : " + byteEncrypted);
                    String textEncrypted = new String(byteEncrypted);
                    return byteEncrypted;
		    
            }catch(IllegalBlockSizeException | BadPaddingException e){
                return null;
            }
                    
        }
        
        
        
        
        /**
         * 
         * @param text
         * @return 
         */
        public String decrypt(byte[] text){
            try{
 
		    
 
                    // Initialize the same cipher for decryption
		    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
 
		    // Decrypt the text
		    byte[] textDecrypted = desCipher.doFinal(text);
 
		    System.out.println("Text Decryted : " + new String(textDecrypted));
                    
                    return new String(textDecrypted);
 
		}catch(InvalidKeyException | IllegalBlockSizeException | BadPaddingException e){
                    e.printStackTrace();
                    return null;
                }
        }
}