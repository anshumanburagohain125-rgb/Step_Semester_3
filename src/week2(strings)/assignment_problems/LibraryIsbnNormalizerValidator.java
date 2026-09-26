import java.util.Scanner;

public class LibraryIsbnNormalizerValidator {
    public static String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        String publisher = code.substring(0, 3).toUpperCase();
        return publisher + code.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append("[").append(code.substring(0, 3)).append("] YEAR: ");
        answer.append(code.substring(3, 7)).append(" | CATALOG: ");
        answer.append(code.substring(7));
        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rawCode = scanner.nextLine();
        String code = normalizeCode(rawCode);
        System.out.println(validateAndFormat(code));
    }
}
