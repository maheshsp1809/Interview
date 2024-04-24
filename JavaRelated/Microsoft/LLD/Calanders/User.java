package LLD.Calanders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

enum EventStatus {
    ACCEPTED,
    REJECTED,
    NEUTRAL
}

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User: " + name + " (" + email + ")";
    }
}
