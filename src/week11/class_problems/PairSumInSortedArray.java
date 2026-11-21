public class PairSumInSortedArray {
    // Time: O(n); additional space: O(1), excluding the returned pair.
    // Ignoring sorted order and checking all pairs takes O(n^2) time.
    public static int[] pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[] { nums[left], nums[right] };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] first = { -4, -1, 0, 3, 5, 9 };
        int[] second = { 1, 2, 3 };
        printPair(pairSumSorted(first, 4));
        printPair(pairSumSorted(second, 100));
    }

    private static void printPair(int[] pair) {
        if (pair == null) {
            System.out.println("Not Found");
        } else {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
