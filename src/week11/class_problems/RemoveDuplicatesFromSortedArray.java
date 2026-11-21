public class RemoveDuplicatesFromSortedArray {
    // Time: O(n); additional space: O(1), so the array is modified in place.
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int uniqueCount = 1;

        for (int current = 1; current < nums.length; current++) {
            if (nums[current] != nums[uniqueCount - 1]) {
                nums[uniqueCount] = nums[current];
                uniqueCount++;
            }
        }

        return uniqueCount;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3, 4, 4, 5 };
        int length = removeDuplicates(nums);

        System.out.print("length = " + length + "\nnums[0.." + (length - 1) + "] = [");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i]);
            if (i < length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
