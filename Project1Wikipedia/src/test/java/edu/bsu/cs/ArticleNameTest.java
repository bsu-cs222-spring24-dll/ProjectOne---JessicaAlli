package edu.bsu.cs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleNameTest {

    @BeforeEach
    public void setUp() {
        // No setup required in this case
    }

    @Test
    public void testGetArticleTitle() {
        String input = "Test Article";
        InputStream originalIn = System.in; // Store original input stream
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = ArticleName.getArticleTitle(new Scanner(System.in));

        assertEquals("Test Article", result);

        // Reset the original input stream after the test
        System.setIn(originalIn);
    }
}
