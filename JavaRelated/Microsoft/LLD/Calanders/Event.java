package LLD.Calanders;

import java.util.*;

class Event {
    private String title;
    private Date start;
    private Date end;
    private String location;
    private User owner;
    private List<User> userList;
    private List<EventStatus> userStatusList;

    public Event(String title, Date start1, Date end1, String location, User owner,
            List<User> userList) {
        this.title = title;
        this.start = start1;
        this.end = end1;
        this.location = location;
        this.owner = owner;
        this.userList = userList;
        this.userStatusList = new ArrayList<>(userList.stream().map(u -> EventStatus.NEUTRAL).toList());
    }

    public void accept(User user) {
        int index = userList.indexOf(user);
        if (index != -1) {
            userStatusList.set(index, EventStatus.ACCEPTED);
        }
    }

    public void reject(User user) {
        int index = userList.indexOf(user);
        if (index != -1) {
            userStatusList.set(index, EventStatus.REJECTED);
        }
    }

    public boolean isAccepted(User user) {
        int index = userList.indexOf(user);
        return index != -1 && userStatusList.get(index) == EventStatus.ACCEPTED;
    }

    public boolean isRejected(User user) {
        int index = userList.indexOf(user);
        return index != -1 && userStatusList.get(index) == EventStatus.REJECTED;
    }

    public boolean isNeutral(User user) {
        int index = userList.indexOf(user);
        return index != -1 && userStatusList.get(index) == EventStatus.NEUTRAL;
    }

    public String getTitle() {
        return title;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    // Getters for other properties
}
