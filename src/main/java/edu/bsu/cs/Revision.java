package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;

public class Revision {

    public String parse(String jsonData) throws IOException {
        JSONArray names = JsonPath.read(jsonData, "$..revisions..user");
        System.out.println("14 Most Recent Revisions:");
        for (int i = 0; i < 14 && i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i).toString());
        }
        return jsonData;
    }

    public String parseTimestamps(String jsonData) throws IOException {
        JSONArray timestamps = JsonPath.read(jsonData, "$..revisions..timestamp");
        System.out.println("Time: ");
        for (int i = 0; i < 14 && i < timestamps.size(); i++) {
            System.out.println((i + 1) + ". " + timestamps.get(i).toString());
        }
        return jsonData;
    }

    public String parseRedirects(String jsonData) throws IOException {
        JSONArray redirects = JsonPath.read(jsonData, "$..redirects");
        if (!redirects.isEmpty()) {
            JSONArray toArray = JsonPath.read(jsonData, "$..redirects[0].to");
            String redirectTo = toArray.isEmpty() ? "" : toArray.get(0).toString();
            System.out.println("Redirected to: " + redirectTo);
        } else {
            System.out.println("No redirects.");
        }
        return jsonData;
    }
}