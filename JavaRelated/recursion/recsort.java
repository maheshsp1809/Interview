package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class recsort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 0, 1, 2, -1));
        sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void sort(List<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        int temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        sort(list);
        insert1(list, temp);
    }

    public static void insert1(List<Integer> list, int temp) {
        if (list.isEmpty() || list.get(list.size() - 1) <= temp) {
            list.add(temp);
            return;
        }
        int lastVal = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        insert1(list, temp);
        list.add(lastVal);
    }

}
