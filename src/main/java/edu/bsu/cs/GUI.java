package edu.bsu.cs;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    private final Button searchButton = new Button("Search");
    private final TextField inputField = new TextField();
    private final TextField outputField = new TextField();

    @Override
    public void start(Stage primaryStage){
        outputField.setEditable(false);
        outputField.setPrefHeight(200);
        configure(primaryStage);
        primaryStage.show();
        configureSearchButton();
    }

    private void configure(Stage stage) {
        Scene scene = new Scene(createRoot(),250,200);
        stage.setTitle("Wikipedia Page Revision List");
        stage.setScene(scene);
        stage.show();
    }

    private Pane createRoot() {
        VBox root = new VBox();
        root.getChildren().addAll(
                new Label("Input:"),
                inputField,
                searchButton,
                new Label("Output:"),
                outputField);
        return root;
    }
    private void configureSearchButton() {
        searchButton.setOnAction(event -> {
            try {
                searchWiki(inputField.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


    }

    private void searchWiki(String input) throws IOException {
        Revision run = new Revision();
        String output = run.parse(input);


        outputField.setText(output);
    }





}
