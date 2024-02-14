package edu.bsu.cs;


import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
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
            System.err.println("No network connection");
        }
    }

    static ArticleName articleName = new ArticleName();
    public static URLConnection connectToWikipedia(ArticleName input) throws IOException {
        //edited from demo
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(articleName.ConfirmName(), Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=14&redirects";
        URL url = new URL(encodedUrlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "ProjectOne(Jessica.walter@bsu.edu)");
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