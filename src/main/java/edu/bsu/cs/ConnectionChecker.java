package edu.bsu.cs;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionChecker {
    public static void main(String[] args) {
        boolean isConnected = checkWikipediaConnection();
        if (isConnected) {
            System.out.println("Connection to Wikipedia is successful.");
        } else {
            System.out.println("Unable to connect to Wikipedia.");
        }
    }

    public static boolean checkWikipediaConnection() {
        try {
            URL url = new URL("https://www.wikipedia.org");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            // Handle connection errors
            e.printStackTrace();
            return false;
        }
    }
}