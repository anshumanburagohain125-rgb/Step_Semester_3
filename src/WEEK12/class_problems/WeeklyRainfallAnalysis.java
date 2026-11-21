import java.util.Locale;
import java.util.Scanner;

public class WeeklyRainfallAnalysis {
    // Time: O(7); space: O(7) for the readings array.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] rainfall = new double[7];
        double total = 0.0;
        int wettestIndex = 0;
        int dryDays = 0;

        for (int i = 0; i < rainfall.length; i++) {
            rainfall[i] = input.nextDouble();
            total += rainfall[i];

            if (rainfall[i] > rainfall[wettestIndex] || i == 0) {
                wettestIndex = i;
            }
            if (rainfall[i] == 0.0) {
                dryDays++;
            }
        }

        System.out.print("Rainfall (mm):");
        for (int i = 0; i < rainfall.length; i++) {
            System.out.printf(Locale.US, " %.1f", rainfall[i]);
        }
        System.out.println();
        System.out.printf(Locale.US, "%nTotal Rainfall: %.1f mm%n", total);
        System.out.printf(Locale.US, "Average Rainfall: %.2f mm%n", total / rainfall.length);
        System.out.printf(Locale.US, "Wettest Day: Day %d (%.1f mm)%n",
                wettestIndex + 1, rainfall[wettestIndex]);
        System.out.println("Total Dry Days: " + dryDays);
    }
}
