package dam.JosantVarona.view;

import dam.JosantVarona.App;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController extends Controller implements Initializable {
    @FXML
    private BorderPane borderPane;
    @FXML
    static Alert alert = new Alert(Alert.AlertType.ERROR);

    private Controller centreController;

    @Override
    public void onOpen(Object input) throws IOException {
        chageScene(Scenes.STAR,null);

    }

    @Override
    public void onClose(Object output) {

    }

    public void chageScene(Scenes scenes,Object data) throws IOException {
        View view = loadFXML(scenes);
        borderPane.setCenter(view.scene);
        this.centreController = view.controller;
        try {
            this.centreController.onOpen(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public static View loadFXML(Scenes scenes)throws IOException {
        String url = scenes.getURL();
        FXMLLoader loader = new FXMLLoader(App.class.getResource(url));
        Parent p = loader.load();
        Controller c = loader.getController();
        View view = new View();
        view.scene =p;
        view.controller=c;
        return view;
    }public void openModalv(Scenes scenes, String tilte, Controller parent, Object data) throws Exception {
        View view = loadFXML(scenes);
        Stage stage = new Stage();
        stage.setTitle(tilte);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(App.stage);
        Scene _scene = new Scene(view.scene);
        stage.setScene(_scene);
        view.controller.onOpen(data);
        stage.showAndWait();
    }
    public static void alertaResgis(){
        alert.setContentText("Esta cuenta ya ha sido registrada o los datos son invalidos");
        alert.setWidth(500);
        alert.setHeight(500);
        alert.showAndWait();
    }
    public static void alertlogin(){
        alert.setContentText("Datos incorrectos");
        alert.showAndWait();
    }
    /*@FXML
    private void closeWindow(Event event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }*/
}
