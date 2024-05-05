package DSAcoding;

public class MaxProductSubarray {
    public static void main(String[] args) {
        PhoneNumber solution = new PhoneNumber();

        // Test cases
        int[] nums1 = { 2, 3, -2, 4 };
        int[] nums2 = { -2, 0, -1 };

        System.out.println("Maximum product subarray for nums1: " + solution.maxProduct(nums1)); // Output: 6
        System.out.println("Maximum product subarray for nums2: " + solution.maxProduct(nums2)); // Output: 0
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            res = Math.max(res, Math.max(prefix, suffix));
        }
        return res;
    }
}
