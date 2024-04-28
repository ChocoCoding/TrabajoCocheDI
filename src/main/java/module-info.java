module com.example.trabajocochedi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.trabajocochedi to javafx.fxml;
    exports com.example.trabajocochedi;
}