package basicJava;

public class CheckForDuplicates {
    static int[] arr = { 2, 14, 3, 4, 2, 14, 3, 8 };

    public static void main(String[] args) {
        int xor = 0;
        for (int i : arr) {
            xor ^= i;
        }
        int rightmostSetBit = xor & -xor;
        System.out.println(rightmostSetBit + " " + xor + " " + -xor);
        String binary = Integer.toBinaryString(-5);
        String binary1 = Integer.toBinaryString(5);
        System.out.println("-xor in binary" + binary);
        System.out.println("xor in binary" + binary1);
        int x = 0, y = 0;
        for (int i : arr) {
            if ((i & rightmostSetBit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        System.out.println("Two non-duplicate elements are " + x + " and " + y);
    }
}
