public class ThreeSum {
    public static int[][] threeSum(int[] nums) {
        sort(nums);
        int[][] temporary = new int[nums.length * nums.length][3];
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    temporary[count][0] = nums[i];
                    temporary[count][1] = nums[left];
                    temporary[count][2] = nums[right];
                    count++;
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        int[][] answer = new int[count][3];
        for (int i = 0; i < count; i++) {
            answer[i] = temporary[i];
        }
        return answer;
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temporary = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temporary;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[][] answer = threeSum(nums);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i][0] + " " + answer[i][1] + " " + answer[i][2]);
        }
    }
}
