package javacodes;

public class MissingAndDuplicate {
        // This is a Java method that takes in an integer array `nums` and an integer `nt` as
        // parameters. It finds the two elements in the array `nums` that are missing and duplicate in
        // the range of 1 to `nt`. It uses XOR operations to calculate the missing and duplicate
        // elements. The method returns an integer array of size 2 containing the missing and duplicate
        // elements.
        int[] findTwoElement(int nums[], int nt) {
        int n = nums.length;
        int xor = 0;
        int setBit = 0;
        int[] result = new int[2];
    
        // Calculate XOR of all elements and indices
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
            xor ^= i + 1;
        }
    
        // Get the rightmost set bit
        setBit = xor & ~(xor - 1);
    
        int num1 = 0;
        int num2 = 0;
    
        // XOR all elements in the array that have the setBit bit set
        for (int i = 0; i < n; i++) {
            if ((nums[i] & setBit) != 0) {
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
    
        // XOR all indices that have the setBit bit set
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
    
        // Check which number is missing and which is repeating
        for (int i = 0; i < n; i++) {
            if (nums[i] == num1) {
                result[0] = num1;
                result[1] = num2;
                break;
            } else if (nums[i] == num2) {
                result[0] = num2;
                result[1] = num1;
                break;
            }
        }
    
        return result;
    }
    
    
}
