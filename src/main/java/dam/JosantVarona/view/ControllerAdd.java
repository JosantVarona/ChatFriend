package dam.JosantVarona.view;

import dam.JosantVarona.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAdd extends Controller implements Initializable {
    @FXML
    private TextField sala;
    @FXML
    private TextField user;
    @FXML
    private Button crear;
    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void goToMain() throws IOException {
        App.currenController.chageScene(Scenes.MAIN,null);
    }
    @FXML
    public void goToMainContax(){
        //crea la sala y vuelve a la pantalla principal
    }
}
