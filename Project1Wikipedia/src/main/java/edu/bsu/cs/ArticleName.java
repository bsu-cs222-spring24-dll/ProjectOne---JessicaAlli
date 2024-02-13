package edu.bsu.cs;

import java.util.Scanner;

public class ArticleName {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter article title from Wikipedia: ");
        String articleTitle = getArticleTitle(console);
        System.out.println("Article title: " + articleTitle);
    }

    static String getArticleTitle(Scanner console) {
        System.out.print("Article title: ");
        return console.nextLine();
    }
}