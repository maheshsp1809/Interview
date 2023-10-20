import java.util.PriorityQueue;
import java.util.Comparator;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class PriorityQueueWithComparator {
    public static void main(String[] args) {
        // Create a PriorityQueue with a custom comparator
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(person -> person.age));

        // Add persons to the priority queue
        priorityQueue.offer(new Person("Alice", 25));
        priorityQueue.offer(new Person("Bob", 30));
        priorityQueue.offer(new Person("Charlie", 22));

        // Retrieve persons based on their age (sorted order)
        while (!priorityQueue.isEmpty()) {
            Person person = priorityQueue.poll();
            System.out.println(person.name + " (" + person.age + " years old)");
        }
    }
}
