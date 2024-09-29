class Solution {
    public int findMin(int[] nums) {
        int l = 0; // Left pointer
        int r = nums.length - 1; // Right pointer

        while (l < r) { // Continue until the left and right pointers meet
            int m = (l + r) / 2; // Middle index (integer division)

            // Compare the middle element with the rightmost element
            if (nums[m] < nums[r]) {
                // The minimum must be in the left half (including nums[m])
                r = m;
            } else {
                // The minimum must be in the right half (excluding nums[m])
                l = m + 1;
            }
        }

        // When the loop ends, l == r, which points to the minimum element
        return nums[l];
    }
}
