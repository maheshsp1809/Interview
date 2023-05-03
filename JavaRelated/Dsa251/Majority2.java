package Dsa251;

import java.util.ArrayList;

public class Majority2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(7);
        arr.add(4);
        arr.add(4);
        arr.add(9);
        arr.add(7);

        ArrayList<Integer> result = majorityElementII(arr);

        System.out.println("Majority elements: " + result.get(0) + " and " + result.get(1));
    }

    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        int c1 = 0;
        int cand1 = 0;
        int c2 = 0;
        int cand2 = 0;
        for (int i = 0; i < arr.size(); ++i) {
            if (c1 == 0) {
                cand1 = arr.get(i);
            }
            if (arr.get(i) == cand1)
                ++c1;
            if (c2 == 0 && arr.get(i) != cand1) {
                cand2 = arr.get(i);
            }
            if (arr.get(i) == cand2)
                ++c2;

            if (arr.get(i) != cand1 && c1 > 0) {
                --c1;
            }
            if (arr.get(i) != cand2 && c2 > 0)
                --c2;

        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(cand1);
        ans.add(cand2);
        return ans;
    }
}
