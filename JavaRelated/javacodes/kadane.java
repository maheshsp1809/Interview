package javacodes;

public class kadane {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        int maxSum = solution.maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + maxSum);
    } 
}
class Solution {
    public int maxSubArray(int[] nums) {
      int maxsofar=nums[0];
      int maxend=nums[0];
      for(int i=1;i<nums.length;++i){
          maxend=Math.max(nums[i], maxend+nums[i]);
          maxsofar=Math.max(maxend,maxsofar);
      }
      return maxsofar;  
    }
}
