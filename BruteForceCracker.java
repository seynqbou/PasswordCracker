package cracker;

public class BruteForceCracker extends Cracker {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    @Override
    public String crackPassword(String charset, String targetPassword) {
        char[] guess = new char[targetPassword.length()];
        if (bruteForce(guess, 0, targetPassword, CHARACTERS)) {
            return new String(guess);
        }
        return null;
    }

    private boolean bruteForce(char[] guess, int position, String targetPassword, String characterSet) {
        if (position == guess.length) {
            String guessString = new String(guess);
            System.out.println("Essai : " + guessString);
            return guessString.equals(targetPassword);
        }

        for (int i = 0; i < characterSet.length(); i++) {
            guess[position] = characterSet.charAt(i);
            if (bruteForce(guess, position + 1, targetPassword, characterSet)) {
                return true;
            }
        }
        return false;
    }
}
