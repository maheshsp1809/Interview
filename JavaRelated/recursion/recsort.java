package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recsort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 0, 1, 2));
        sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void sort(List<Integer> list) {
        if (list.size() == 1) {
            return;
        }
        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        sort(list);
        insert(list, temp);
    }

    public static void insert1(List<Integer> list, int temp) {
        if (list.isEmpty() || list.get(list.size() - 1) <= temp) {
            list.add(temp);
            return;
        }
        for (int i = list.size() - 2; i >= 0; i--) {
            int val = list.get(i);
            if (val <= temp) {
                list.add(i + 1, temp);
                return;
            }
            list.set(i + 1, val);
        }
        list.set(0, temp);
    }

}
