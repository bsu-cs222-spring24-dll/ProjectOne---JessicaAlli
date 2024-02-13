package edu.bsu.cs;

import java.time.LocalDateTime;

public class Revision {
    private String username;
    private LocalDateTime timestamp;

    public Revision(String username, LocalDateTime timestamp) {
        this.username = username;
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int compareTo(Revision other) {
        // Compare revisions based on their timestamps in descending order
        return other.timestamp.compareTo(this.timestamp);
    }
}

