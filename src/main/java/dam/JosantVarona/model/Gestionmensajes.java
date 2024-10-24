package dam.JosantVarona.model;

import dam.JosantVarona.Datos.mensajesXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Gestionmensajes {
    public File archivo = new File("mensajes.xml");

    /*public Gestionmensajes() {
        this.mensajes = new ArrayList<>();
    }*/

    public void enviarMensakes(Message message) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(mensajesXML.class);
        Unmarshaller um = context.createUnmarshaller();
        mensajesXML wrapper = (mensajesXML) um.unmarshal(archivo);

        List<Message> mensajes = wrapper.getMesaje();
        mensajes.add(message);
        guardarMensajesXML(mensajes);
    }

    public List<Message> getMensajes(User emisor, User receptor) throws JAXBException {
        List<Message> mensajesEmisorReceptor = new ArrayList<>();
        JAXBContext context = JAXBContext.newInstance(mensajesXML.class);
        Unmarshaller um = context.createUnmarshaller();
        mensajesXML wrapper = (mensajesXML) um.unmarshal(archivo);

        // Obtener la lista de mensajes deserializados
        List<Message> mensajes = wrapper.getMesaje();
        for (Message mensaje : mensajes) {
            if ((mensaje.getEmisor().equals(emisor) && mensaje.getReceptor().equals(receptor)) ||
                    (mensaje.getEmisor().equals(receptor) && mensaje.getReceptor().equals(emisor))) {
                mensajesEmisorReceptor.add(mensaje);
            }
        }
        return mensajesEmisorReceptor;
    }
    //Investigar como guardar el mensaje y cargarlo

    public void guardarMensajesXML(List<Message> mensa) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(mensajesXML.class);

        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        mensajesXML mensajesXML = new mensajesXML();
        mensajesXML.setMesajes(mensa);

        m.marshal(mensajesXML, archivo);
    }
}
