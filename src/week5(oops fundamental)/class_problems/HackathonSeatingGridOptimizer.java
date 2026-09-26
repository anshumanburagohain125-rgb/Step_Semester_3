public class HackathonSeatingGridOptimizer {
    private static double rowAverage(int[] row) {
        int total = 0;
        for (int score : row) {
            total = total + score;
        }
        return (double) total / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        String result = "";

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);
            String zone;

            if (average < threshold) {
                zone = "Quiet Zone";
            } else {
                zone = "Buzzing Zone";
            }

            result = result + "Row " + i + ": " + zone;
            if (i < seatingScores.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] seatingScores = {{40, 50, 45}, {85, 90, 95}, {30, 20, 25}};
        int threshold = 60;
        System.out.println(classifyRows(seatingScores, threshold));
    }
}
