import java.lang.reflect.Array;
import java.util.Arrays;

class Student {
    int roll = 1;
    String name = "Kafil";
    float marks = 90.9f;
}

public class Test extends Student {
    public static void main(String[] args) {
        float marks;
        Student afroz = new Test();
        System.out.println(afroz.marks);

    }
}
