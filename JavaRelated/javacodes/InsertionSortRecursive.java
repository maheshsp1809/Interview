import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSortRecursive {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(4, 3, 2, 10, 12, 1, 5, 6));
        insertionSortRecursive(list);
        System.out.println(list);
    }

    public static void insertionSortRecursive(List<Integer> list) {
        // base case
        if (list.size() <= 1) {
            return;
        }

        int lastElement = list.remove(list.size() - 1); // remove last element
        // sort first n-1 elements recursively
        insertionSortRecursive(list);

        // insert last element at its correct position
        insertRecursive(list, lastElement);
    }

    public static void insertRecursive(List<Integer> list, int lastElement) {
        // base case
        if (list.size() == 0 || list.get(list.size() - 1) <= lastElement) {
            list.add(lastElement); // insert last element at its correct position
            return;
        }

        // recursively insert the last element at its correct position
        int val = list.remove(list.size() - 1);
        insertRecursive(list, lastElement);
        list.add(val); // add back the removed element
    }
}
