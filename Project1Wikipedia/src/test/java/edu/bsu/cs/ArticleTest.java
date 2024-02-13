package edu.bsu.cs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    @Test
    void testArticleRetrieval() {
        // Replace "Cat" with the title of the Wikipedia article you want to test
        String articleTitle = "Cat";
        try {
            Article.main(new String[]{articleTitle});
        } catch (Exception e) {
            fail("Exception occurred during article retrieval: " + e.getMessage());
        }
    }
}
