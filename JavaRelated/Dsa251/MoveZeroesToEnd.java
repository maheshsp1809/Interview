package Dsa251;

import java.util.ArrayList;

public class MoveZeroesToEnd {
    public static void pushZerosAtEnd(ArrayList<Integer> nums) {
        int left = 0, right = 0;
        while (right < nums.size()) {
            if (nums.get(right) != 0) {
                int temp = nums.get(left);
                nums.set(left, nums.get(right));
                nums.set(right, temp);
                left++;
            }
            right++;
        }
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(0);
        nums.add(1);
        nums.add(0);
        nums.add(3);
        nums.add(12);

        System.out.println("Before moving zeroes to end: " + nums);
        pushZerosAtEnd(nums);
        System.out.println("After moving zeroes to end: " + nums);
    }
}
