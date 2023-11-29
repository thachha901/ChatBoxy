package com.example.chatboxy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Mess newMess = new Mess();

        primaryStage.setTitle("ChatBox App");

        // Layout
        BorderPane borderPane = new BorderPane();
        VBox vbox = new VBox();

        // Chat Area
        newMess.chatArea = new TextArea();
        newMess.chatArea.setEditable(false);
        newMess.chatArea.setWrapText(true);
        VBox.setMargin(newMess.chatArea, new Insets(10, 10, 10, 10));
        vbox.getChildren().add(newMess.chatArea);

        // Message Input Field
        newMess.messageField = new TextField();
        newMess.messageField.setPromptText("Type your message...");
        VBox.setMargin(newMess.messageField, new Insets(0, 10, 10, 10));
        vbox.getChildren().add(newMess.messageField);

        // Send Button
        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> newMess.sendMessage());
        VBox.setMargin(sendButton, new Insets(0, 10, 10, 10));
        vbox.getChildren().add(sendButton);

        // Add components to BorderPane
        borderPane.setCenter(vbox);

        // Scene
        Scene scene = new Scene(borderPane, 600, 480);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
