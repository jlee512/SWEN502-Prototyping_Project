package Controller;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Julian on 3/10/2017.
 */
public class Passwords {
    private static final Random RANDOM = new SecureRandom();
    private static final int KEY_LENGTH = 512;

    /**
     * Returns a random number of iterations to be used when hashing a password.
     */
    public static int getNextNumIterations() {
        return (int) (RANDOM.nextDouble() * 90_000 + 10000);
    }


    /**
     * Returns a salted and hashed password using the provided hash.<br>
     * Note - side effect: the password is destroyed (the char[] is filled with zeros)
     *
     * @param password   the password to be hashed
     * @param iterations the number of iterations to use in the hashing process
     * @return the hashed password with a pinch of salt
     * Note: salted with "burgerco'
     */
    public static byte[] hash(char[] password, int iterations) {
        PBEKeySpec spec = new PBEKeySpec(password, "burgerco".getBytes(), iterations, KEY_LENGTH);

        // Blank out the provided password array - prevents accidental leakage of this information
        Arrays.fill(password, Character.MIN_VALUE);

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

}
