package qualcomm.codes;

import java.util.*;

class MapPractice {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        System.out.println(map.getOrDefault("orange", 50));
        System.out.println(map.putIfAbsent("mahesh", 25));
        System.out.println(map.putIfAbsent("apple", 35));
        // use stram api to print map its keys and values
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        System.out.println();
        System.out.println();

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println("key" + " " + m.getKey() + " " + "value" + " " + m.getValue());
        }
    }
}
