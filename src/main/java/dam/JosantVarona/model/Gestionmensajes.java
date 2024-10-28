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
    //Esta variable es para saber donde esta el archivo xml de los mensajes
    public File archivo = new File("mensajes.xml");

    /*public Gestionmensajes() {
        this.mensajes = new ArrayList<>();
    }*/

    /**
     * Este metodo trae todos los mensajes que tenga el xml y añade el nuevo
     * @param message nuevo mesajes del usuario
     * @throws JAXBException
     */
    public void enviarMensakes(Message message) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(mensajesXML.class);
        Unmarshaller um = context.createUnmarshaller();
        mensajesXML wrapper = (mensajesXML) um.unmarshal(archivo);

        List<Message> mensajes = wrapper.getMesaje();
        mensajes.add(message);
        guardarMensajesXML(mensajes);
    }

    /**
     * Este metodo filtra los mensajes y trae solo los del emisor y el receptor.
     * @param emisor Usuario iniciado
     * @param receptor contecto elegido
     * @return list de mensajes del emisor y el receptor
     * @throws JAXBException
     */
    public List<Message> getMensajes(User emisor, User receptor) throws JAXBException {
        List<Message> mensajesEmisorReceptor = new ArrayList<>();
        JAXBContext context = JAXBContext.newInstance(mensajesXML.class);
        Unmarshaller um = context.createUnmarshaller();
        mensajesXML wrapper = (mensajesXML) um.unmarshal(archivo);

        // Obtener la lista de mensajes deserializados
        List<Message> mensajes = wrapper.getMesaje();
        for (Message mensaje : mensajes) {
            if (mensaje.getEmisor() != null && mensaje.getReceptor() != null) {
                if ((mensaje.getEmisor().equals(emisor) && mensaje.getReceptor().equals(receptor)) ||
                        (mensaje.getEmisor().equals(receptor) && mensaje.getReceptor().equals(emisor))) {
                    mensajesEmisorReceptor.add(mensaje);
                }
            }
        }
        return mensajesEmisorReceptor;
    }

    /**
     * Guarda todos los mensajes nuevo y viejos
     * @param mensa list de todos los mensajes nuevo y viejos
     * @throws JAXBException
     */
    public void guardarMensajesXML(List<Message> mensa) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(mensajesXML.class);

        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        mensajesXML mensajesXML = new mensajesXML();
        mensajesXML.setMesajes(mensa);

        m.marshal(mensajesXML, archivo);
    }
}
