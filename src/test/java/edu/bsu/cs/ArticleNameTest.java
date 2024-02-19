package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static edu.bsu.cs.ArticleName.console;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleNameTest {

    @Test
    public void ArticleNameInputTest() {
        ArticleName articleName = new ArticleName();
        String name = articleName.ConfirmName();
        Assertions.assertNotNull(name);
    }
}
