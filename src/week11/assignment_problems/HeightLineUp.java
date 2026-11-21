public class HeightLineUp {
    public static void lineUp(int[] heights) {
        for (int pass = 1; pass < heights.length; pass++) {
            boolean swapped = false;

            for (int j = 0; j < heights.length - pass; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.print("Pass " + pass + ": ");
            printArray(heights);

            if (!swapped) {
                break;
            }
        }

        if (heights.length <= 1) {
            System.out.print("Pass 1: ");
            printArray(heights);
        }
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

    public static void main(String[] args) {
        System.out.println("Sample 1:");
        lineUp(new int[] { 4, 2, 5, 1 });

        System.out.println("Sample 2:");
        lineUp(new int[] { 1, 3, 2, 4 });

        System.out.println("Additional test:");
        lineUp(new int[] { 5, 1, 4, 2 });
    }
}
