module com.example.chatboxy {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;


    opens com.example.chatboxy to javafx.fxml;
    exports com.example.chatboxy;
}