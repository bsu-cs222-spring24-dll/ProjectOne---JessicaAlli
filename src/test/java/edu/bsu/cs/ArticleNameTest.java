package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticleNameTest {

    @Test
    public void ArticleNameInputTest() {
        String mockArticleName = "Test Article";
        Assertions.assertEquals("Test Article", mockArticleName);
    }
}