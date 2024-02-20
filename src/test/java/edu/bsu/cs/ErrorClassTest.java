package edu.bsu.cs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ErrorClassTest {
    @Test
    public void testNoWikiArticlePage() {
        // Given
        ErrorClass errorClass = new ErrorClass();
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(errContent));

        // When no relevant page is found
        String missingData = "missing: Some missing data";
        errorClass.noWikiArticlePage(missingData);

        // Then an error message should be printed to stderr
        Assertions.assertTrue(errContent.toString().contains("No Relevant Wiki Page Available"));

        // Reset the error stream
        System.setErr(originalErr);
    }}