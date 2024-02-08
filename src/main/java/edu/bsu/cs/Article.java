package edu.bsu.cs;

import java.io.IOException;
import java.net.URLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class Article {
    public static void main(String[] args) throws IOException {
        try {
            URLConnection connection = connectionToWiki();
            String jsonOutput = convertJsonToString(connection);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            private static URLConnection connectionToWiki() throws IOException{

                String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                        + URLEncoder.encode("Zappa", Charset.defaultCharset()) +
                        "&rvprop=timestamp|user&rvlimit=4&redirects";
                URL url = new URL(encodedUrlString);
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("User-Agent",
                        "ProjectOne (allison.carr@bsu.edu");
                connection.connect();
                return connection;
            }

            private static String convertJsonToString(URLConnection connection) throws IOException {
                return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
            }

        }
