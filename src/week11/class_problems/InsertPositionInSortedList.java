public class InsertPositionInSortedList {
    // Binary search: O(log n) time and O(1) additional space.
    public static int searchInsertPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        System.out.println(searchInsertPosition(nums, 5));
        System.out.println(searchInsertPosition(nums, 2));
    }
}
