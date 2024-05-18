package cracker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MD5Cracker extends Cracker {
    @Override
    public String crackPassword(String dictionaryFilePath, String hash) {
        try (BufferedReader br = new BufferedReader(new FileReader(dictionaryFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (getMD5Hash(line).equals(hash)) {
                    System.out.println("Mot de passe MD5 trouvé dans le dictionnaire : " + line);
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
