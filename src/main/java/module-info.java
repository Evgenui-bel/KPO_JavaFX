module com.example.kpo_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;


    opens com.example.kpo_javafx to javafx.fxml;
    exports com.example.kpo_javafx;
    exports com.example.kpo_javafx.Controller;
    opens com.example.kpo_javafx.Controller to javafx.fxml;
}