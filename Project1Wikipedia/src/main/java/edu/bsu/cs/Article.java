package edu.bsu.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Article {
    public static void main(String[] args) {
        String articleTitle;
        if (args.length == 0) {
            System.err.println("Error: Please provide an article title as a command-line argument.");
            return;
        } else {
            articleTitle = args[0];
        }

        try {
            URLConnection connection = connectionToWiki(articleTitle);
            String jsonResponse = convertJsonToString(connection);
            List<Revision> revisions = parseJsonResponse(jsonResponse);
            if (revisions.isEmpty()) {
                System.err.println("Error: There is no Wikipedia page for the article name provided.");
            } else {
                printRevisions(revisions);
            }
        } catch (IOException e) {
            System.err.println("Error: Network error occurred. " + e.getMessage());
        }
    }

    private static URLConnection connectionToWiki(String articleTitle) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                + URLEncoder.encode(articleTitle, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=14&redirects";
        URL url = new URL(encodedUrlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "ProjectOne (allison.carr@bsu.edu)");
        connection.connect();
        return connection;
    }

    private static String convertJsonToString(URLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }

    private static List<Revision> parseJsonResponse(String jsonResponse) {
        List<Revision> revisions = new ArrayList<>();
        // Your JSON parsing logic here
        return revisions;
    }

    private static void printRevisions(List<Revision> revisions) {
        for (Revision revision : revisions) {
            System.out.println(revision);
        }
    }
}
