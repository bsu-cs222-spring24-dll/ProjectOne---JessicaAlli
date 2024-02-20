package edu.bsu.cs;

public class ErrorClass {
    public void noWikiArticlePage(String data) {
        //Error handling for the case if there is no wikipedia article for the article name entered
        if (data.contains("missing")) {
            System.err.println("No Relevant Wiki Page Available");
        }

    }
}
