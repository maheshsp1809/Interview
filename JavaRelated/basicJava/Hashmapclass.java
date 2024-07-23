package basicJava;

import java.util.HashMap;
import java.util.Map;

class Employ {
    String name;
    int empid;

    public Employ(String name, int empid) {
        this.name = name;
        this.empid = empid;
    }

    @Override
    public String toString() {
        return "Employ{name='" + name + "', empid=" + empid + '}';
    }

    @Override
    public int hashCode() {
        return empid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Employ employ = (Employ) obj;
        return empid == employ.empid && name.equals(employ.name);
    }
}

public class Hashmapclass {
    public static void main(String[] args) {
        // Initialize the map
        Map<Employ, String> map = new HashMap<>();

        // Add three employees
        map.put(new Employ("mahesh", 1), "mahesh@gmail.com");
        map.put(new Employ("vinayk", 2), "vinayk@gmail.com");
        map.put(new Employ("veeresh", 3), "veeresh@gmail.com");

        // Print the map
        for (Map.Entry<Employ, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
