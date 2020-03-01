package bg.jug.website.core.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.Key;

public class CryptUtils {

    private static final String KEY = "lkjq9q91jaq*9!l#";

    public static byte[] encryptPassword(String password) {
        Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            return cipher.doFinal(password.getBytes());
        } catch (Exception e) {
            return password.getBytes(StandardCharsets.UTF_8);
        }
    }

}
