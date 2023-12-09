package com.example.chatboxy;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Mess implements Initializable {

    @FXML
    TextField messageField;
    @FXML
    TextArea chatArea;

    void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            chatArea.appendText("You: " + message + "\n");
            messageField.clear();
        }
    }

    void getMessage() {
        String message = messageField.getText();
        if(!message.isEmpty()) {
            chatArea.appendText("Him: " + message + "\n");
            messageField.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
