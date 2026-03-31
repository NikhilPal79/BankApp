package LearnWithNikhil.BankingApp.Utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Fingerprints {
    ///  what does this class does is type the request input and hash the content

    private Fingerprints() {}
    /// A private constructor. This prevents anyone from creating an instance of Fingerprints. Since all methods are static,
    /// the class is meant to be used without instantiation (a utility class).


    public static String customerCreate(String firstName, String lastName, String email, String phone, String address) {
        String s = (firstName == null ? "" : firstName.trim().toLowerCase()) + "|" +
                   (lastName == null ?  "" : lastName.trim().toLowerCase())  + "|" +
                   (email == null ?  "" : email.trim().toLowerCase())        + "|" +
                   (phone == null ? "" : phone.trim())                       + "|" +
                   (address ==null ? "" : address.trim().toLowerCase());
        return sha256(s);
    }
    private static String sha256(String s) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(s.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
