package cracker;

import java.util.Scanner;

public class PasswordCracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Voulez-vous craquer un mot de passe ou un hash ?");
            System.out.println("1. Craquer un mot de passe");
            System.out.println("2. Craquer un hash");
            System.out.println("0. Quitter");

            int choixPrincipal = Integer.parseInt(scanner.nextLine());
            switch (choixPrincipal) {
                case 0:
                    System.out.println("Fin du programme.");
                    scanner.close();
                    return;
                case 1:
                    craquerMotDePasse(scanner);
                    break;
                case 2:
                    craquerHash(scanner);
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez saisir 1, 2 ou 0.");
            }
        }
    }

    private static void craquerMotDePasse(Scanner scanner) {
        while (true) {
            System.out.println("Choisissez la méthode (1. Force brute, 2. Dictionnaire, 3. Retourner au menu précédent) :");
            int methode = Integer.parseInt(scanner.nextLine());

            switch (methode) {
                case 1:
                    System.out.println("Entrez le mot de passe cible :");
                    String motDePasseCible = scanner.nextLine();
                    Cracker bruteForceCracker = new BruteForceCracker();
                    try {
                        String resultatBruteForce = bruteForceCracker.crackPassword("", motDePasseCible);
                        System.out.println("Mot de passe craqué : " + resultatBruteForce);
                    } catch (Exception e) {
                        System.out.println("Une erreur s'est produite : " + e.getMessage());
                    }
                    return;
                case 2:
                    System.out.println("Entrez le chemin du fichier de dictionnaire :");
                    String cheminDictionnaire = scanner.nextLine();
                    System.out.println("Entrez le mot de passe cible :");
                    String motDePasseCibleDico = scanner.nextLine();
                    Cracker dictionaryCracker = new DictionaryCracker();
                    try {
                        String resultatDictionnaire = dictionaryCracker.crackPassword(cheminDictionnaire, motDePasseCibleDico);
                        System.out.println("Mot de passe craqué : " + resultatDictionnaire);
                    } catch (Exception e) {
                        System.out.println("Une erreur s'est produite : " + e.getMessage());
                    }
                    return;
                case 3:
                    return; // Retourner au menu principal
                default:
                    System.out.println("Choix invalide. Veuillez saisir 1, 2 ou 3.");
            }
        }
    }

    private static void craquerHash(Scanner scanner) {
        while (true) {
            System.out.println("Choisissez la méthode (1. MD5, 2. SHA1, 3. Retourner au menu précédent) :");
            int methode = Integer.parseInt(scanner.nextLine());

            switch (methode) {
                case 1:
                    System.out.println("Entrez le chemin du fichier de dictionnaire :");
                    String cheminDictionnaire = scanner.nextLine();
                    System.out.println("Entrez le hash cible :");
                    String hashMD5 = scanner.nextLine();
                    Cracker md5Cracker = new MD5Cracker();
                    try {
                        String resultatMD5 = md5Cracker.crackPassword(cheminDictionnaire, hashMD5);
                        System.out.println("Mot de passe MD5 craqué : " + resultatMD5);
                    } catch (Exception e) {
                        System.out.println("Une erreur s'est produite : " + e.getMessage());
                    }
                    return;
                case 2:
                    System.out.println("Entrez le chemin du fichier de dictionnaire :");
                    String cheminDictionnaireSHA1 = scanner.nextLine();
                    System.out.println("Entrez le hash cible :");
                    String hashSHA1 = scanner.nextLine();
                    Cracker sha1Cracker = new SHA1Cracker();
                    try {
                        String resultatSHA1 = sha1Cracker.crackPassword(cheminDictionnaireSHA1, hashSHA1);
                        System.out.println("Mot de passe SHA1 craqué : " + resultatSHA1);
                    } catch (Exception e) {
                        System.out.println("Une erreur s'est produite : " + e.getMessage());
                    }
                    return;
                case 3:
                    return; // Retourner au menu principal
                default:
                    System.out.println("Choix invalide. Veuillez saisir 1, 2 ou 3.");
            }
        }
    }
}
