package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleTest {

    @Test
    public void testAccessToJsonFile() throws IOException {
        String jsonData = readSampleFileAsString();
        Assertions.assertNotNull(jsonData);
    }

    @Test
    public void testCountRevisions() throws IOException {
        String jsonData = readSampleFileAsString();
        Revision revision = new Revision();
        revision.parse(jsonData);
        int actualNumberOfRevisions = 14;
        assertEquals(14, actualNumberOfRevisions);
    }

    private String readSampleFileAsString() throws NullPointerException, IOException {
        try (InputStream sampleFile = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("test.json")) {
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        }
    }

    private JSONArray getRevisionsFromJson(String jsonData) {
        return JsonPath.read(jsonData, "$..revisions[*]");
    }
}