package javacodes;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Intstream {
    public static void main(String[] args) {
        int[] arr = { 7, 4, 9, 2, 5, 3, 6, 1, 8 };
        
        // sum
        int sum = Arrays.stream(arr).sum();
        System.out.println("Sum: " + sum);
        
        // average
        double average = Arrays.stream(arr).average().getAsDouble();
        System.out.println("Average: " + average);
        
        // min
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println("Min: " + min);
        
        // max
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("Max: " + max);
        
        // count
        long count = Arrays.stream(arr).count();
        System.out.println("Count: " + count);
        
        // distinct
        int[] distinctArr = Arrays.stream(arr).distinct().toArray();
        System.out.println("Distinct: " + Arrays.toString(distinctArr));
        
        // sorted
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        System.out.println("Sorted: " + Arrays.toString(sortedArr));
        
        // map
        int[] mappedArr = Arrays.stream(arr).map(x -> x * 2).toArray();
        System.out.println("Mapped: " + Arrays.toString(mappedArr));
        
        // filter
        int[] filteredArr = Arrays.stream(arr).filter(x -> x % 2 == 0).toArray();
        System.out.println("Filtered: " + Arrays.toString(filteredArr));
        
        // flatMap
        int[] flatMappedArr = Arrays.stream(arr).flatMap(x -> IntStream.range(0, x)).toArray();
        System.out.println("FlatMapped: " + Arrays.toString(flatMappedArr));
    }
}
