package edu.bsu.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Article {
    public static void main(String[] args) throws IOException {
        try {
            ArticleName input = new ArticleName();
            ErrorClass error = new ErrorClass();
            URLConnection connection = connectToWikipedia(input);
            String jsonData = getJsonData(connection);
            error.noWikiArticlePage(jsonData);
            printRawJson(jsonData);
            Revision parser = new Revision();
            parser.parse(jsonData);
            parser.parseTimestamps(jsonData);
            parser.parseRedirects(jsonData);
        } catch (UnknownHostException e) {
            System.err.println("NO CONNECTION DETECTED");
        }
    }

    public static URLConnection connectToWikipedia(ArticleName input) throws IOException {
        String searchTerm = input.articleName(new Scanner(System.in));
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(searchTerm, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=14&redirects";
        URL url = new URL(encodedUrlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Project1-Justis-Ethan (justis.guin@bsu.edu)");
        connection.connect();
        return connection;

    }

    private static String getJsonData(URLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        StringBuilder jsonData = new StringBuilder();
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        while (scanner.hasNext()) {
            jsonData.append(scanner.nextLine());
        }
        scanner.close();
        return jsonData.toString();
    }

    private static void printRawJson(String jsonData) {
        System.out.println(jsonData);
    }
}