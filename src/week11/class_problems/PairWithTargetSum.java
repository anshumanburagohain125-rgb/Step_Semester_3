import java.util.HashSet;

public class PairWithTargetSum {
    // Hash-set approach: average O(n) time and O(n) additional space.
    // Brute force checks all pairs in O(n^2) time with O(1) additional space.
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (seen.contains(complement)) {
                return true;
            }
            seen.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] first = { 2, 7, 11, 15 };
        int[] second = { 3, 4, 6 };

        System.out.println(hasPairWithSum(first, 9));
        System.out.println(hasPairWithSum(second, 20));
    }
}
