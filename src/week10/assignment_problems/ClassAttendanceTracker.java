public class ClassAttendanceTracker {
    // Time: O(n); additional space: O(1), excluding the returned pair.
    public static int[] attendanceSummary(int[] days) {
        int presentDays = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                presentDays++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[] { presentDays, longestStreak };
    }

    public static void main(String[] args) {
        int[] days = { 1, 1, 0, 1, 1, 1, 0, 1 };
        int[] result = attendanceSummary(days);

        System.out.println("Present: " + result[0]
                + ", Longest streak: " + result[1]);
    }
}
