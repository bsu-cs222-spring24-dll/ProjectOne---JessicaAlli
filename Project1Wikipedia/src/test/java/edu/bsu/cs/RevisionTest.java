package edu.bsu.cs;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RevisionTest {

    @Test
    void testGetUsername() {
        // Arrange
        String username = "testUser";
        LocalDateTime timestamp = LocalDateTime.now();
        Revision revision = new Revision(username, timestamp);

        // Act
        String actualUsername = revision.getUsername();

        // Assert
        assertEquals(username, actualUsername);
    }

    @Test
    void testGetTimestamp() {
        // Arrange
        String username = "testUser";
        LocalDateTime timestamp = LocalDateTime.now();
        Revision revision = new Revision(username, timestamp);

        // Act
        LocalDateTime actualTimestamp = revision.getTimestamp();

        // Assert
        assertEquals(timestamp, actualTimestamp);
    }
}