public class PrizeTable {
    public static int prizeTable(int[] marks) {
        int swaps = 0;

        for (int position = 0; position < marks.length - 1; position++) {
            int largestIndex = position;

            for (int i = position + 1; i < marks.length; i++) {
                if (marks[i] > marks[largestIndex]) {
                    largestIndex = i;
                }
            }

            if (largestIndex != position) {
                int temp = marks[position];
                marks[position] = marks[largestIndex];
                marks[largestIndex] = temp;
                swaps++;
            }
        }

        return swaps;
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

    private static void runTest(String label, int[] marks) {
        System.out.println(label);
        int swaps = prizeTable(marks);
        printArray(marks);
        System.out.println("swaps = " + swaps);
    }

    public static void main(String[] args) {
        runTest("Sample 1:", new int[] { 45, 90, 60, 75 });
        runTest("Sample 2:", new int[] { 80, 70, 60 });
        runTest("Additional test:", new int[] { 5, 1, 4, 2 });
    }
}
