package javacodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class subsets {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(0);
        list.add(2);
        list.add(3);
        list.add(1);
        int k = getSubsets(list);
        System.out.println(k);
    }

    public static int getSubsets(ArrayList<Integer> list) {
        int n = list.size();
        int sum = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += list.get(i);

            if (sum == 0) {
                maxLen = i + 1;
            } else if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        return maxLen;
    }

}
