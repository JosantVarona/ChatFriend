package dam.JosantVarona.view;

import dam.JosantVarona.model.Gestionmensajes;
import dam.JosantVarona.model.Message;
import dam.JosantVarona.model.User;
import dam.JosantVarona.model.userSesion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ControllerChat extends Controller implements Initializable {

    @FXML
    private ComboBox <String> filtradoUsuario;
    @FXML
    private ListView<Message> messages;
    @FXML
    private Button enviar;
    @FXML
    private TextField contenido;
    @FXML
    private  TextField filtrado;
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
     filtradoUsuario.setItems(FXCollections.observableArrayList("Ambos","Emisor", "Receptor"));
     filtradoUsuario.setValue("Ambos");
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

    @FXML
    public void transformarTXT() throws IOException, JAXBException {
        if (mess != null) {

            User receptor1 = receptor;
            User emisor1 = userSesion.getInstancia().getUsuarioIniciado();
            FileWriter writer = new FileWriter(emisor1.getUsername()+"-"+receptor1.getUsername()+".txt");
            for (Message message : mess) {
                writer.write(message.getEmisor().getUsername() + ": " + message.getContenido() + "\n");
            }
            writer.close();
        }
    }
    @FXML
    public void filtrar() throws IOException, JAXBException {
        ObservableList<Message> filteredMessages = mess.stream()
                .filter(message -> message.getContenido().contains(filtrado.getText()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        messages.setItems(filteredMessages);
        messages.refresh();
    }
    @FXML
    public void filtrareEmisor () throws IOException, JAXBException {
        User recep = receptor;
        switch (filtradoUsuario.getValue()) {
            case "Emisor":
                ObservableList<Message> filteredMessages = mess.stream()
                        .filter(message -> message.getEmisor().equals(userSesion.getInstancia().getUsuarioIniciado()))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                messages.setItems(filteredMessages);
                messages.refresh();
                break;
            case "Receptor":
                ObservableList<Message> filtered = mess.stream()
                        .filter(message -> message.getEmisor().equals(recep))
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                messages.setItems(filtered);
                messages.refresh();
                break;
            case "Ambos":
                filteredMessages = mess.stream()
                        .collect(Collectors.toCollection(FXCollections::observableArrayList));
                messages.setItems(filteredMessages);
                messages.refresh();
                break;
        }
    }
    @FXML
    public void resumenChat () throws IOException, JAXBException {
        User receptor1 = receptor;
        User emisor1 = userSesion.getInstancia().getUsuarioIniciado();
        FileWriter writer = new FileWriter("resumenChat"+emisor1.getUsername()+"-"+receptor1.getUsername()+".txt");
        writer.write("Chat entre " + emisor1.getUsername() + " y " + receptor1.getUsername() + "\n");
        writer.write("Cantidad de mensajes enviados: " + mess.size() + "\n");
        writer.write("Cantidad de mensajes enviados por emisor: " + mess.stream().filter(message -> message.getEmisor().equals(emisor1)).count() + "\n");
        writer.write("Cantidad de mensajes enviados por receptor: " + mess.stream().filter(message -> message.getEmisor().equals(receptor1)).count() + "\n");
        writer.close();
    }
}