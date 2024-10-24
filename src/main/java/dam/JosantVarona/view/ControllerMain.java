package dam.JosantVarona.view;

import dam.JosantVarona.App;
import dam.JosantVarona.Datos.usuariosXML;
import dam.JosantVarona.model.User;
import dam.JosantVarona.model.userSesion;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerMain extends Controller implements Initializable {
    @FXML
    private ImageView arrow;
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn <User,String> columnick;

    private ObservableList<User> usuariosc;
    @Override
    public void onOpen(Object input) throws Exception {
        User usario = (User) input;
        usuariosXML usuariosXML = new usuariosXML();
        List<User> usuarios = usuariosXML.getUsers();
        usuarios.remove(usario);
        this.usuariosc = FXCollections.observableArrayList(usuarios);
        tableView.setItems(this.usuariosc);
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnick.setCellValueFactory(User -> new SimpleStringProperty(User.getValue().username));
    }

    public void goToLogin() throws IOException{
        App.currenController.chageScene(Scenes.LOGIN,null);
        userSesion.getInstancia().logOut();
        //aqui cerramos la intancia
    }
    @FXML
    private void chatContac() throws Exception {
        User usuario = tableView.getSelectionModel().getSelectedItem();
        App.currenController.openModalv(Scenes.CHAT, "Chat abierto", this, usuario);
    }


}
