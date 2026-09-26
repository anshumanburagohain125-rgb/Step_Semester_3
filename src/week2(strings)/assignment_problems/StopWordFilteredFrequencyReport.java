import java.util.Scanner;

public class StopWordFilteredFrequencyReport {
    public static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");
        String[] uniqueWords = new String[words.length];
        int[] counts = new int[words.length];
        int uniqueCount = 0;

        for (int i = 0; i < words.length; i++) {
            boolean stopWord = false;

            for (int j = 0; j < stopWords.length; j++) {
                if (words[i].equals(stopWords[j])) {
                    stopWord = true;
                }
            }

            if (!stopWord) {
                int wordPosition = -1;

                for (int j = 0; j < uniqueCount; j++) {
                    if (uniqueWords[j].equals(words[i])) {
                        wordPosition = j;
                    }
                }

                if (wordPosition == -1) {
                    uniqueWords[uniqueCount] = words[i];
                    counts[uniqueCount] = 1;
                    uniqueCount++;
                } else {
                    counts[wordPosition]++;
                }
            }
        }

        for (int i = 0; i < uniqueCount - 1; i++) {
            for (int j = i + 1; j < uniqueCount; j++) {
                if (counts[j] > counts[i]) {
                    int temporaryCount = counts[i];
                    counts[i] = counts[j];
                    counts[j] = temporaryCount;

                    String temporaryWord = uniqueWords[i];
                    uniqueWords[i] = uniqueWords[j];
                    uniqueWords[j] = temporaryWord;
                }
            }
        }

        for (int i = 0; i < uniqueCount; i++) {
            System.out.println(uniqueWords[i] + ": " + counts[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String feedback = scanner.nextLine();
        printFilteredWordFrequency(feedback);
    }
}
