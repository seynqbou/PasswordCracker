package cracker;

public class PasswordCrackerFactory {
    public static Cracker getCracker(String method) {
        switch (method.toLowerCase()) {
            case "bruteforce":
                System.out.println("Création d'un casseur de mot de passe par force brute.");
                return new BruteForceCracker();
            case "dictionary":
                System.out.println("Création d'un casseur de mot de passe par dictionnaire.");
                return new DictionaryCracker();
            case "md5":
                System.out.println("Création d'un casseur de mot de passe pour MD5.");
                return new MD5Cracker();
            case "sha1":
                System.out.println("Création d'un casseur de mot de passe pour SHA1.");
                return new SHA1Cracker();
            default:
                throw new IllegalArgumentException("Méthode de cracking inconnue : " + method);
        }
    }
}
