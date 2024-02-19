package edu.bsu.cs;

public class ErrorClass {
    public void noWikiArticlePage(String data){
        if (data.contains("missing")){
            System.err.println("No page found that is relevant to this search");
        }
    }

}
