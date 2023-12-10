// ChatController.java
package com.example.chatboxy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Mess {
    @FXML
    private ListView<HBox> chatListView;

    @FXML
    private TextField messageField;

    @FXML
    private void sendMessage(ActionEvent event) {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            HBox messageBox = createMessageBox("You", message);
            chatListView.getItems().add(messageBox);
            messageField.clear();
        }
    }

    private HBox createMessageBox(String sender, String message) {
        HBox messageBox = new HBox(10);

        // Ảnh đại diện
        ImageView avatarImageView = new ImageView(new Image(ClassLoader.getSystemResource("pic/dm.png").toExternalForm()));

        avatarImageView.setFitWidth(50);
        avatarImageView.setFitHeight(50);

        // Nội dung tin nhắn
        HBox messageContent = new HBox(5);
        messageContent.getChildren().add(new ImageView(new Image(getClass().getResource("/pic/" + sender.toLowerCase() + "dm.png").toExternalForm())));
        messageContent.getChildren().add(new javafx.scene.control.Label(message));

        if (sender.equals("You")) {
            messageBox.getChildren().addAll(messageContent, avatarImageView);
        } else {
            messageBox.getChildren().addAll(avatarImageView, messageContent);
        }

        return messageBox;
    }

}
