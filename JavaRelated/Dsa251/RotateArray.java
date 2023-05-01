package Dsa251;

import java.util.Arrays;

public class RotateArray {

    // public static int[] rotateArray(int[] nums, int k) {
    // int n = nums.length;
    // int[] rotated = new int[n];
    // for (int i = 0; i < n; i++) {
    // int newIndex = (n + i - k) % n;
    // rotated[newIndex] = nums[i];
    // }
    // return rotated;
    // }
    public static void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle the case where k > n
        int count = 0;
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (n + current - k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        rotateArray(nums, k);
        System.out.println("Original array: " + Arrays.toString(nums));

    }
}
