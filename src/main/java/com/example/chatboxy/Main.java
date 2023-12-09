package com.example.chatboxy;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Init in = new Init();
        in.init(primaryStage, "sample.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
