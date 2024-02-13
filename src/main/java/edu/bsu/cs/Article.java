package edu.bsu.cs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Article {
    public static void main(String[] args) {
        try {
            URLConnection connection = connectionToWiki();
            String jsonResponse = convertJsonToString(connection);
            List<Revision> revisions = parseJsonResponse(jsonResponse);
            for (Revision revision : revisions) {
                System.out.println(revision);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static URLConnection connectionToWiki() throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                + URLEncoder.encode("Zappa", Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=4&redirects";
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
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONObject query = jsonObject.getJSONObject("query");
        JSONArray redirects = query.optJSONArray("redirects");
        if (redirects != null && redirects.length() > 0) {
            System.out.println("Redirected to " + redirects.getJSONObject(0).getString("to"));
        }
        JSONObject pages = query.getJSONObject("pages");
        JSONObject page = pages.getJSONObject(pages.keys().next());
        JSONArray revisionsArray = page.getJSONArray("revisions");
        for (int i = 0; i < revisionsArray.length(); i++) {
            JSONObject revision = revisionsArray.getJSONObject(i);
            String username = revision.getString("user");
            LocalDateTime timestamp = LocalDateTime.parse(revision.getString("timestamp"));
            revisions.add(new Revision(username, timestamp));
        }
        return revisions;
    }
}
