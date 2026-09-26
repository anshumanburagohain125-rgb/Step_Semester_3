import java.util.Scanner;

public class VowelConsonantCounter {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            char lowerLetter = Character.toLowerCase(letter);

            if (lowerLetter == 'a' || lowerLetter == 'e' || lowerLetter == 'i'
                    || lowerLetter == 'o' || lowerLetter == 'u') {
                vowels++;
            } else if (lowerLetter >= 'a' && lowerLetter <= 'z') {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        countVowelsAndConsonants(text);
    }
}
