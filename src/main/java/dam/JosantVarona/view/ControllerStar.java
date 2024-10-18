package dam.JosantVarona.view;

import dam.JosantVarona.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerStar extends Controller implements Initializable {
    @FXML
    ImageView image;
    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void gotoLogin() throws IOException{
        System.out.println(Scenes.STAR);
        App.currenController.chageScene(Scenes.LOGIN,null);
    }
}
