package dam.JosantVarona.Datos;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class mensajesXML {
    private File archivo = new File("mensajes.xml");

    public void guardarMensajesXML() throws Exception {
        JAXBContext context = JAXBContext.newInstance(mensajesXML.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(this, archivo);
    }

}
