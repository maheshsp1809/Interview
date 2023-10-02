import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        // Student afroz;
        // System.out.println(Arrays.toString(students));

        Student afroz = new Student();
        // afroz.roll = 8;
        // afroz.name = "Afroz Alam";
        afroz.marks = 75.5f;
        System.out.println(afroz.roll);
        System.out.println(afroz.name);
        System.out.println(afroz.marks);

    }
}

class Student {
    int roll = 1;
    String name = "Kafil";
    float marks = 90.9f;
}
