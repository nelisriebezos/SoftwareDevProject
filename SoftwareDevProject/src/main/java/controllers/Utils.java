package controllers;

import domeinKlassen.Gebruiker;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Utils {
	// tests Utils functions
    public static void main(String[] args) {
        String password = "password";
        String hashedPassword = Utils.hashPassword(password);
        Gebruiker g1 = new Gebruiker("test@test.nl", hashedPassword, "test", "test");
        System.out.println(password + " " + hashedPassword);
        System.out.println(g1.toString() + " Password gelijk " + checkPassword(g1, password));
    }
    
    // hashes password using a salt
    public static String hashPassword(String password) throws RuntimeException {
        int iterations = 100000;
        int keyLength = 512;
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = "12786357162354716121263542872064".getBytes();
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            return Hex.encodeHexString(keyFactory.generateSecret(new PBEKeySpec(passwordChars, saltBytes, iterations,
                    keyLength)).getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    // checks if passwords are equal
    public static boolean checkPassword(Gebruiker user, String password) {
        return user.getWachtwoord().equals(Utils.hashPassword(password));
    }
}
