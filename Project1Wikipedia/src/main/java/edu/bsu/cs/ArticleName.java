package edu.bsu.cs;

import java.util.Scanner;

public class ArticleName {

    public String articleName(Scanner scanner) {
        System.out.println("Enter Article Name From Wiki:");
        String input = scanner.nextLine();
        if (input.isEmpty()){
            System.err.println("No Article Entered");
        }
        return input;

    }
}