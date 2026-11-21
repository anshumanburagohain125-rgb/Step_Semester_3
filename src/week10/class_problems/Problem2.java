import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.next();

        String reversed = new StringBuilder(word).reverse().toString();

        System.out.println(reversed + (word.equals(reversed)
                ? " - palindrome"
                : " - not a palindrome"));
    }
}
