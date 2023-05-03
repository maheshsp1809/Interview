package Dsa251;

import java.util.Arrays;

public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int modified = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                if (modified == 1) {
                    return false;
                }
                if (i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
                modified++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 2, 3 };
        boolean result = checkPossibility(nums);
        System.out.println("Input: " + Arrays.toString(nums) + " Output: " + result);

        nums = new int[] { 4, 2, 1 };
        result = checkPossibility(nums);
        System.out.println("Input: " + Arrays.toString(nums) + " Output: " + result);

        nums = new int[] { 3, 4, 2, 3 };
        result = checkPossibility(nums);
        System.out.println("Input: " + Arrays.toString(nums) + " Output: " + result);

        nums = new int[] { 1, 2, 3, 4 };
        result = checkPossibility(nums);
        System.out.println("Input: " + Arrays.toString(nums) + " Output: " + result);
    }
}
