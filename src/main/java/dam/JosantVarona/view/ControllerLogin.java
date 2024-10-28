package dam.JosantVarona.view;

import dam.JosantVarona.App;
import dam.JosantVarona.model.User;
import dam.JosantVarona.Datos.usuariosXML;
import dam.JosantVarona.model.userSesion;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerLogin extends Controller implements Initializable {
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
    @FXML
    private Button iniciar;
    @FXML
    private Button register;
    @Override
    public void onOpen(Object input) throws IOException {

    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Recoge todos los datos
     * @return usuario nuevo
     * @throws Exception
     */
    private User recogerDatos() throws Exception {
        User result = null;
        String nick = user.getText();
        String pass1 = pass.getText();
        String security = User.segurity(pass1);
        User aux = new User(nick,security);
        if (nick != null && !nick.trim().isEmpty()) {
            if (!yaInsertado(aux)) {
                result = aux;
            }
        }
        return result;
    }

    /**
     * Comprueba el usuario introducido
     * @return usuario ya iniciado
     * @throws Exception
     */
    private User loginCuenta() throws Exception {
        User login = null;
        String nick = user.getText();
        String pass1 = pass.getText();
        String security = User.segurity(pass1);
        User aux = new User(nick,security);
        if (login(aux)){
            if (aux!= null){
                login = aux;
            }
        }
        return login;
    }


    /**
     * Cambia de escena
     * @throws Exception
     */
    @FXML
    private void goToMain() throws Exception {
        //
        if (loginCuenta()!= null){
            App.currenController.chageScene(Scenes.MAIN,loginCuenta());
            userSesion.getInstancia().logIn(loginCuenta());
        } else {
            AppController.alertlogin();
        }
    }

    /**
     * registra el usuario y cmabia de escena
     * @throws Exception
     */
    @FXML
    private void goToMainR() throws Exception {
        usuariosXML resgitrar = new usuariosXML();
        if (recogerDatos() != null){
            App.currenController.chageScene(Scenes.MAIN,recogerDatos());
            resgitrar.añadirUsuario(recogerDatos());
            userSesion.getInstancia().logIn(recogerDatos());
        } else {
            AppController.alertaResgis();
        }
    }

    /**
     * comprueba si el usuario ya ha sido introducido
     * @param usIntroducido
     * @return el usuario no esta introducido
     * @throws Exception
     */
    private boolean yaInsertado(User usIntroducido) throws Exception {
        boolean result = false;
        usuariosXML usuariosRegistrados= new usuariosXML();
        List<User> lista = usuariosRegistrados.getUsers();
        for (User user : lista){
            if (user.equals(usIntroducido)){
                result = true;
            }
        }
        return result;
    }

    /**
     * Comprueva si el usuario es igual al que ya esta registrado
     * @param user
     * @return el usuario no esta registrado si es false
     * @throws Exception
     */
    private boolean login(User user) throws Exception {
        boolean result = false;
        if (user !=null){
        usuariosXML usuariosRegistrados = new usuariosXML();
        List<User> lista = usuariosRegistrados.getUsers();
        for (User user1 : lista) {
            if (user1.getUsername().equals(user.getUsername()) && user1.getPassword().equals(user.getPassword())) {
                result = true;
            }
        }
    }
        return result;
    }

}
