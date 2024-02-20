package edu.bsu.cs;

import java.util.Scanner;

public class ArticleName {
    //Creates an instance of the Scanner class
    public static Scanner console = new Scanner(System.in);

    public String ConfirmName() {
        //Allows the user to input an article title
        System.out.println("Enter article name: ");
        String input = console.nextLine();
        //If the input is empty, an error is returned
        if (input.isEmpty()) {
            System.err.println("No name entered");
        }
        return input;
    }
}