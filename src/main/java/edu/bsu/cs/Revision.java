package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.json.JSONObject;

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
        JSONObject jsonObject = new JSONObject(jsonData);
        org.json.JSONArray redirects = jsonObject.optJSONArray("redirects");
        if (redirects != null && redirects.length() > 0) {
            JSONObject redirectObject = redirects.getJSONObject(0);
            String redirectTo = redirectObject.optString("to", "");
            System.out.println("Redirected to: " + redirectTo);
            return redirectTo;
        } else {
            System.out.println("No redirects.");
            return "";
        }
    }
}

