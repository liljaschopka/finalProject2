module hi.userinterface.finalproject2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens hi.userinterface.finalproject2 to javafx.fxml;
    exports hi.userinterface.finalproject2;
}
