package dam.JosantVarona.view;

import dam.JosantVarona.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMain extends Controller implements Initializable {
    @FXML
    private ImageView image;
    @FXML
    private ImageView arrow;
    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void goToAdd() throws IOException {
        System.out.println(Scenes.ADD);
        App.currenController.chageScene(Scenes.ADD,null);
    }
    public void goToLogin() throws IOException{
        App.currenController.chageScene(Scenes.LOGIN,null);
        //aqui cerramos la intancia
    }

}
