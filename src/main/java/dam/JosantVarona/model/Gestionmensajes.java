package dam.JosantVarona.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Gestionmensajes {
    private List<Message> mensajes;

    public Gestionmensajes() {
        this.mensajes = new ArrayList<>();
    }

    public void enviarMensakes(User receptor, User emisor, String mensaje, LocalDateTime horafecha) {
        Message nuevoMensaje = new Message(receptor, emisor, mensaje, horafecha);
        mensajes.add(nuevoMensaje);
        guardarMensajesXML();
    }

    public List<Message> getMensajes(User emisor, User receptor) {
        List<Message> mensajesEmisorReceptor = new ArrayList<>();
        for (Message mensaje : mensajes) {
            if ((mensaje.getEmisor().equals(emisor) && mensaje.getReceptor().equals(receptor)) ||
                    (mensaje.getEmisor().equals(receptor) && mensaje.getReceptor().equals(emisor))) {
                mensajesEmisorReceptor.add(mensaje);
            }
        }
        return mensajesEmisorReceptor;

    }
    //Investigar como guardar el mensaje y cargarlo

    private void guardarMensajesXML() {
    }
}
