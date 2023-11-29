package com.example.chatboxy;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Mess {

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
}
