module dam.JosantVarona {
    requires javafx.controls;
    requires javafx.fxml;

    opens dam.JosantVarona to javafx.fxml;
    exports dam.JosantVarona;
}
