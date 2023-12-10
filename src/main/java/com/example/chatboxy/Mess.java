package com.example.chatboxy;

import com.jfoenix.controls.JFXTextArea;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Mess implements Initializable {
    @FXML
    VBox vbox = new VBox(5);
    @FXML
    ScrollPane scroll;
    @FXML
    JFXTextArea text;
    @FXML
    AnchorPane root;
    @FXML
    ImageView sw;
    public static AnchorPane groot = null;
    private Pos pos;
    private String addStyle;
    private ImageView icon1 = null;
    private ImageView icon2 = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        groot = root;

        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setFitToWidth(true);
        //scroll.setDisable(true);

        vbox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                scroll.setVvalue((Double)t1);
            }
        });

        text.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try{ Send(new ActionEvent()); }
                catch (Exception err) {};
            }
        });

        pos = Pos.CENTER_RIGHT;
        addStyle = "send_text";
        try {
            InputStream stream = new FileInputStream("src/main/resources/com/example/chatboxy/pic/Harry_Potter.png");
            Image image = new Image(stream, 35, 35,false,false);
            icon1 = new ImageView(image);
            InputStream stream2 = new FileInputStream("src/main/resources/com/example/chatboxy/pic/attach.png");
            Image image2 = new Image(stream2, 35, 35,false,false);
            icon2 = new ImageView(image2);
        } catch (FileNotFoundException e) {
            System.out.print(111);
        }
    }

    public void Switch (ActionEvent event) {
        if(pos == Pos.CENTER_RIGHT) {
            pos = Pos.CENTER_LEFT;
            addStyle = "receive_text";
            sw.setImage(icon2.getImage());
        }
        else {
            pos = Pos.CENTER_RIGHT;
            addStyle = "send_text";
            sw.setImage(icon1.getImage());
        }
    }

    public void Send(ActionEvent event) throws Exception{
        if(Objects.equals(text.getText().trim(), "")) return;
        String mes = text.getText().trim();
        HBox hBox = new HBox(10);
        hBox.setAlignment(pos);
        hBox.setPadding(new Insets(5,5,5,10));

        Text tex = new Text(mes);
        TextFlow flow = new TextFlow(tex);
        flow.getStylesheets().add(getClass().getResource("style.css").toString());
        flow.getStyleClass().add(addStyle);
        flow.setPadding(new Insets(5,10,5,10));
        tex.setFill(Color.BLACK);
        tex.setFont(new Font("Arial", 20));

        if(pos == Pos.CENTER_RIGHT) {
            hBox.getChildren().add(flow);
            hBox.getChildren().add(new ImageView(icon1.getImage()));
        }
        else {
            hBox.getChildren().add(new ImageView(icon2.getImage()));
            hBox.getChildren().add(flow);
        }
        vbox.getChildren().add(hBox);
        text.clear();
    }


    public void Exit(ActionEvent event) throws Exception {
        Init.exit(event);
    }
}