package Dsa251;

import java.util.*;

public class PositiveNega {
    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        int[] result = separateNegativeAndPositive(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] separateNegativeAndPositive(int a[]) {
        int l = 0;
        int h = a.length - 1;
        while (l < h) {
            if (a[l] >= 0) {
                if (a[h] < 0) {
                    int temp = a[l];
                    a[l] = a[h];
                    a[h] = temp;
                } else {
                    --h;
                }
            } else {
                ++l;
            }
        }
        return a;

    }
}
