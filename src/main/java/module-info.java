module dam.JosantVarona {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.desktop;

    opens dam.JosantVarona to javafx.fxml;
    opens dam.JosantVarona.view to javafx.fxml;
    opens dam.JosantVarona.Datos to java.xml.bind;
    opens dam.JosantVarona.model to java.xml.bind;

    exports dam.JosantVarona;
    exports dam.JosantVarona.view;
    exports dam.JosantVarona.utils;
    exports dam.JosantVarona.model;
}

