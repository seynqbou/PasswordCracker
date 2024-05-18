package cracker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryCracker extends Cracker {
    @Override
    public String crackPassword(String dictionaryFilePath, String targetPassword) {
        try (BufferedReader br = new BufferedReader(new FileReader(dictionaryFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(targetPassword)) {
                    System.out.println("Mot de passe trouvé dans le dictionnaire : " + line);
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
