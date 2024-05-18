# Password Cracker

Ce projet consiste à simuler un craqueur de mots de passe en utilisant plusieurs méthodes : force brute, dictionnaire, MD5 et SHA-1. Le projet utilise le patron de conception Factory pour créer les instances appropriées de craquage.

## Fonctionnalités

- *Force Brute* : Essaie toutes les combinaisons possibles de caractères pour trouver le mot de passe.
- *Dictionnaire* : Utilise une liste de mots de passe courants pour trouver une correspondance.
- *MD5* : Compare les hachages MD5 des mots de passe dans un fichier avec un hachage cible donner par l'utilisateur
- *SHA-1* : Compare les hachages SHA-1 des mots de passe dans un fichier avec un hachage cible que l'utilisateur donne egalement

## Structure du Projet

- Cracker.java : Interface définissant la méthode crackPassword.
- BruteForceCracker.java : Implémentation de l'attaque par force brute.
- DictionaryCracker.java : Implémentation de l'attaque par dictionnaire.
- MD5Cracker.java : Implémentation de l'attaque utilisant des hachages MD5.
- SHA1Cracker.java : Implémentation de l'attaque utilisant des hachages SHA-1.
- PasswordCrackerFactory.java : Utilise le pattern Factory pour créer des instances des classes de craquage.
- PasswordCracker.java : Point d'entrée du programme, interagit avec l'utilisateur.
- passwordlist.txt : Contient une liste de mots de passe courants pour l'attaque par dictionnaire.

## Compilation
Placez a la racine et entrez la commande suivante:
javac -d bin src/cracker/*.java

## Execution
Entrez la commande
java -cp bin cracker.PasswordCracker
Suivez les instructions à l'écran pour choisir la méthode de craquage et fournir les entrées nécessaires.


