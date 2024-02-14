package edu.bsu.cs;


import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class Article {
    static ArticleNameInput articleName = new ArticleNameInput();
    public static URLConnection connectToWikipedia() throws IOException {
        //edited from demo
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(articleName.validateName(), Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=14&redirects";
        URL url = new URL(encodedUrlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "ProjectOne (jessica.walter@bsu.edu)");
        connection.connect();
        return connection;
    }
    public static String readJsonAsStringFrom(URLConnection connection) throws IOException {
        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }

    public static void printRawJson(String jsonData) {
        System.out.println(jsonData);
    }
}

