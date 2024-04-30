module org.cs2.phoorder {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.cs2.phoorder to javafx.fxml;
    exports org.cs2.phoorder;
}