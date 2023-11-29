module com.example.chatboxy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatboxy to javafx.fxml;
    exports com.example.chatboxy;
}