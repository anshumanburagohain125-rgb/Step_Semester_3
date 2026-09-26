public class TypingSpeedTestAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int mistake = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (mistake == -1) {
                mistake = i;
            }
        }

        double accuracy = matched * 100.0 / original.length();
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched,
                original.length(), accuracy);

        if (mistake == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(" | First Mismatch at position " + (mistake + 1)
                    + " ('" + original.charAt(mistake) + "' vs '"
                    + typed.charAt(mistake) + "')");
        }
    }

    public static void main(String[] args) {
        String original = "hello world";
        String typed = "hello worlt";
        checkTypingAccuracy(original, typed);
    }
}
