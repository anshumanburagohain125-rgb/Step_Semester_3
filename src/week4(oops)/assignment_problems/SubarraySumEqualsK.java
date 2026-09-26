import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int currentSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            int neededSum = currentSum - k;

            if (sums.containsKey(neededSum)) {
                count = count + sums.get(neededSum);
            }

            if (sums.containsKey(currentSum)) {
                sums.put(currentSum, sums.get(currentSum) + 1);
            } else {
                sums.put(currentSum, 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }
}
