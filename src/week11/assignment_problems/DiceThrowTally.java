public class DiceThrowTally {
    public static int[] diceSort(int[] rolls) {
        int[] counts = new int[7];

        for (int i = 0; i < rolls.length; i++) {
            counts[rolls[i]]++;
        }

        System.out.print("Counts: ");
        for (int value = 1; value <= 6; value++) {
            System.out.print(value + ":" + counts[value]);
            if (value < 6) {
                System.out.print(" ");
            }
        }
        System.out.println();

        int[] sorted = new int[rolls.length];
        int index = 0;

        for (int value = 1; value <= 6; value++) {
            for (int count = 0; count < counts[value]; count++) {
                sorted[index] = value;
                index++;
            }
        }

        return sorted;
    }

    private static void printArray(int[] values) {
        System.out.print("[");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i < values.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static void runTest(String label, int[] rolls) {
        System.out.println(label);
        int[] sorted = diceSort(rolls);
        System.out.print("Sorted: ");
        printArray(sorted);
    }

    public static void main(String[] args) {
        runTest("Sample:", new int[] { 4, 1, 6, 4, 2, 1, 4 });
        runTest("Additional test:", new int[] { 6, 3, 3, 1, 5 });
    }
}
