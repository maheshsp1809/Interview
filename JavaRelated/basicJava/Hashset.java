package basicJava;

import java.util.*;

public class Hashset {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(3, 2, 1); // a duplicate of list1

        Set<List<Integer>> set = new HashSet<>();
        set.add(list1);
        set.add(list2);
        set.add(list3); // this will not be added to the set because it's a duplicate of list1

        System.out.println(set); // output: [[1, 2, 3], [4, 5, 6]]
    }
}
 