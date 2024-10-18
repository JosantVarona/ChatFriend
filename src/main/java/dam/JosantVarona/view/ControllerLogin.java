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

public class ControllerLogin extends Controller implements Initializable {
    @FXML
    private TextField user;
    @FXML
    private PasswordField texPass;
    @FXML
    private Button iniciar;
    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void goToMain() throws IOException {
        App.currenController.chageScene(Scenes.MAIN,null);
        //Crear una instacia
    }
}
