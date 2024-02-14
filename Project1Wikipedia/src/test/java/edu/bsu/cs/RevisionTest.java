package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RevisionTest {

    @Test
    public void testNameParse() throws IOException {
        Revision parser = new Revision();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String user = parser.parse(String.valueOf(testDataStream));
        Assertions.assertEquals("24.143.118.36", user);


    }
    @Test
    public void testTimestamps() throws IOException{
        Revision parser = new Revision();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamps = parser.parseTimestamps(String.valueOf(testDataStream));
        Assertions.assertEquals("2024-02-04T18:19:33Z", timestamps);
    }
    @Test
    public void testRedirects()throws IOException{
        Revision parser = new Revision();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String redirects = parser.parseRedirects(testDataStream.toString());
        Assertions.assertEquals("Frank Zappa", redirects);
    }

}