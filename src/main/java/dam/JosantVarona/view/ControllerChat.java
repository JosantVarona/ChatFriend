package dam.JosantVarona.view;

import dam.JosantVarona.model.Gestionmensajes;
import dam.JosantVarona.model.Message;
import dam.JosantVarona.model.User;
import dam.JosantVarona.model.userSesion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerChat extends Controller implements Initializable {

    @FXML
    private ListView<Message> messages;
    @FXML
    private Button enviar;
    @FXML
    private TextField contenido;

    private ObservableList<Message> mess;
    private User receptor = null;

    @Override
    public void onOpen(Object input) throws Exception {
        Gestionmensajes gestion = new Gestionmensajes();

        User aux = (User) input;
        receptor = aux;

        User emisor = userSesion.getInstancia().getUsuarioIniciado();

        List<Message> messageslist = gestion.getMensajes(emisor, receptor);
        this.mess = FXCollections.observableArrayList(messageslist);

        messages.setItems(this.mess);
    }

    @Override
    public void onClose(Object output) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        messages.setCellFactory(lv -> new ListCell<Message>() {
            @Override
            protected void updateItem(Message message, boolean empty) {
                super.updateItem(message, empty);
                if (empty || message == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    // Mostrar el emisor y el contenido del mensaje
                    if (message.getEmisor().equals(userSesion.getInstancia().getUsuarioIniciado())) {
                        // Mensaje del emisor, alineado a la derecha
                        setText("Tú: " + message.getContenido());
                        setStyle("-fx-alignment: CENTER-RIGHT; -fx-background-color: lightblue; -fx-padding: 5px;");
                    } else {
                        // Mensaje del receptor, alineado a la izquierda
                        setText(message.getEmisor().getUsername() + ": " + message.getContenido());
                        setStyle("-fx-alignment: CENTER-LEFT; -fx-background-color: lightgreen; -fx-padding: 5px;");
                    }
                }
            }
        });
    }

    @FXML
    private void enviarMensaje() throws IOException, JAXBException {
        User recep = receptor;
        User emisor = userSesion.getInstancia().getUsuarioIniciado();
        String contenidoMensaje = contenido.getText();

        if (!contenidoMensaje.isEmpty()) {  // Asegúrate de no enviar mensajes vacíos
            Message nuevoMensaje = new Message(recep, emisor, contenidoMensaje);
            Gestionmensajes gestionmensajes = new Gestionmensajes();
            gestionmensajes.enviarMensakes(nuevoMensaje);
            mess.add(nuevoMensaje);
            messages.refresh();
            contenido.clear();
        }
    }
}