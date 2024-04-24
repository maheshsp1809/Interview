package LLD.Calanders;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("John Doe", "john@example.com");
        User user2 = new User("Jane Smith", "jane@example.com");
        User user3 = new User("Bob Johnson", "bob@example.com");

        // Create a calendar instance
        Calendar calendar = new Calendar();

        // Create events
        Date start1 = new Date();
        Date end1 = new Date(start1.getTime() + 3600000); // 1 hour later
        List<User> userList1 = List.of(user1, user2, user3);
        Event event1 = new Event("Team Meeting", start1, end1, "Conference Room", user1, userList1);

        Date start2 = new Date(start1.getTime() + 7200000); // 2 hours after start1
        Date end2 = new Date(start2.getTime() + 3600000); // 1 hour after start2
        List<User> userList2 = List.of(user2, user3);
        Event event2 = new Event("Project Discussion", start2, end2, "Meeting Room", user2, userList2);

        // Add events to the calendar
        calendar.addEvent(event1);
        calendar.addEvent(event2);

        // Simulate user actions
        event1.accept(user1);
        event1.accept(user2);
        event1.reject(user3);

        event2.accept(user2);
        event2.accept(user3);

        // Get free slots for a list of users
        List<User> userList = List.of(user1, user2);
        List<Event> freeSlots = calendar.getFreeSlots(userList);
        for (User e : userList) {
            System.out.println(e + " ");
        }
        System.out.println("Free slots for users " + userList + ":");
        for (Event event : freeSlots) {
            System.out.println(event.getTitle() + " (" + event.getStart() + " - " + event.getEnd() + ")");
        }
    }
}
