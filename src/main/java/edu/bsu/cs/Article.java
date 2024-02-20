package edu.bsu.cs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Article {
    public static void main(String[] args) {
        try {
            // Get the article name from the user
            String articleName = ArticleName.getArticleNameFromUser();

            // Connect to Wikipedia API and fetch JSON data
            String jsonData = fetchArticleJsonData(articleName);

            if (jsonData != null && !jsonData.isEmpty()) {
                // Print raw JSON data
                printRawJson(jsonData);

                // Parse JSON data
                Revision parser = new Revision();
                parser.parse(jsonData);
                parser.parseTimestamps(jsonData);
                parser.parseRedirects(jsonData);
            } else {
                System.out.println("No data received from Wikipedia API.");
            }
        } catch (UnknownHostException e) {
            System.err.println("No network connection");
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }

    public static String fetchArticleJsonData(String articleName) throws IOException {
        String encodedArticleName = URLEncoder.encode(articleName, StandardCharsets.UTF_8);
        String apiUrl = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                + encodedArticleName + "&rvprop=timestamp|user&rvlimit=14&redirects";

        URL url = new URL(apiUrl);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Project1Wikipedia(allison.carr@bsu.edu)");
        connection.connect();

        try (InputStream inputStream = connection.getInputStream();
             Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
            StringBuilder jsonData = new StringBuilder();
            while (scanner.hasNextLine()) {
                jsonData.append(scanner.nextLine());
            }
            return jsonData.toString();
        }
    }

    private static void printRawJson(String jsonData) {
        System.out.println(jsonData);
    }
}