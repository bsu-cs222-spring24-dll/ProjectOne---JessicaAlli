package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RevisionTest {

    @Test
    public void testParse() throws IOException {
        // Given
        String jsonData = "{\"revisions\": {\"user\": [\"User1\", \"User2\"], \"timestamp\": [\"Timestamp1\", \"Timestamp2\"]}}";
        Revision revision = new Revision();

        // When
        String parsedData = revision.parse(jsonData);

        // Then
        assertEquals(jsonData, parsedData);
    }

    @Test
    public void testParseTimestamps() throws IOException {
        // Given
        String jsonData = "{\"revisions\": {\"timestamp\": [\"Timestamp1\", \"Timestamp2\"]}}";
        Revision revision = new Revision();

        // When
        String parsedTimestamps = revision.parseTimestamps(jsonData);

        // Then
        assertEquals(jsonData, parsedTimestamps);
    }

    @Test
    public void testParseRedirects_WithRedirects() throws IOException {
        // Given
        String jsonDataWithRedirects = "{\"redirects\": [{\"to\": \"Page1\"}]}";
        Revision revision = new Revision();

        // When
        String redirectedPage = revision.parseRedirects(jsonDataWithRedirects);

        // Then
        assertEquals("Page1", redirectedPage);
    }

    @Test
    public void testParseRedirects_WithoutRedirects() throws IOException {
        // Given
        String jsonDataWithoutRedirects = "{}";
        Revision revision = new Revision();

        // When
        String redirectedPage = revision.parseRedirects(jsonDataWithoutRedirects);

        // Then
        assertEquals("", redirectedPage);
    }
}



