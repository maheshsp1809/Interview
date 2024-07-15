package javacodes.javastreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaStream {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Doe");
        Stream<String> nameStream = names.stream();
    }
}
