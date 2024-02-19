package edu.bsu.cs;

import java.util.Scanner;

public class ArticleName {
    public static Scanner console = new Scanner(System.in);

    public String ConfirmName() {
        System.out.println("Enter article name: ");
        String input = console.nextLine();
        if (input.isEmpty()) {
            System.err.println("No name entered");
        }
        return input;
    }
}