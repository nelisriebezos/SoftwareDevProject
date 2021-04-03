package controllers;
import org.apache.commons.codec.binary.Hex;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashMethoden {
    public static void main(String[] args) {
        String password = "password";
        String salt = "12786357162354716121263542872064";
        int iterations = 100000;
        int keyLength = 512;
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = salt.getBytes();

        byte[] hashedBytes = hashPassword(passwordChars, saltBytes, iterations, keyLength);
        String hashedString = Hex.encodeHexString(hashedBytes);

        System.out.println(hashedString);
    }

    public static byte[] hashPassword(final char[] password, final byte[] salt, final int iterations, final int keylength) {
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keylength);
            SecretKey key = keyFactory.generateSecret(spec);
            return key.getEncoded();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
