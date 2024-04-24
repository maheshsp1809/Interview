package LLD.Calanders;

import java.util.*;

class Calendar {
    private List<Event> events;

    public Calendar() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public void updateEvent(Event event) {
        int index = events.indexOf(event);
        if (index != -1) {
            events.set(index, event);
        }
    }

    public void deleteEvent(Event event) {
        events.remove(event);
    }

    public List<Event> getEvents() {
        return events;
    }

    public List<Event> getFreeSlots(List<User> userList) {
        List<Event> freeSlots = new ArrayList<>();
        for (Event event : events) {
            boolean allAccepted = true;
            for (User user : userList) {
                if (!event.isAccepted(user)) {
                    allAccepted = false;
                    break;
                }
            }
            if (allAccepted) {
                freeSlots.add(event);
            }
        }
        return freeSlots;
    }
}
