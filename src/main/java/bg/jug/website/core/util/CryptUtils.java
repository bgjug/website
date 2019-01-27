package bg.jug.website.core.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class CryptUtils {

    private static final String KEY = "lkjq9q91jaq*9!l#";

    public static String encryptPassword(String password) {
        Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(password.getBytes());
            return new String(encrypted);
        } catch (Exception e) {
            return password;
        }
    }

}
