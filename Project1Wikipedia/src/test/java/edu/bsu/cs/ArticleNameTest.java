package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleNameTest {

    @Test
    public void testArticleNameInput() {
        String testInput = "Ocean";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        ArticleName input = new ArticleName();
        String result = input.articleName(new Scanner(System.in));
        Assertions.assertEquals(testInput, result);
    }
}
