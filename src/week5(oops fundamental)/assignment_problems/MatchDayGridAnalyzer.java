public class MatchDayGridAnalyzer {
    private static double rowAverage(int[] row) {
        int total = 0;
        for (int runs : row) {
            total = total + runs;
        }
        return (double) total / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        String result = "";

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);
            String type;

            if (average >= threshold) {
                type = "Power Surge";
            } else {
                type = "Normal";
            }

            result = result + "Match " + i + ": " + type;
            if (i < runsPerOver.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] runsPerOver = {{4, 6, 8}, {10, 12, 14}, {2, 3, 1}};
        int threshold = 8;
        System.out.println(classifyMatches(runsPerOver, threshold));
    }
}
