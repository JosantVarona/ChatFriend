package dam.JosantVarona.Datos;

import dam.JosantVarona.model.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class usuariosXML {
    //Variable que tiene el archivo xml de usuarios.
    private File archivo = new File("users.xml");

    /**
     * Guarda los usuarios viejos y nuevos
     * @param users list de todos los usuarios
     * @throws JAXBException
     */
    public void guardarUsuario(List<User> users) throws JAXBException {
        conexionXMLUsuario wrapper = new conexionXMLUsuario();
        ;
        wrapper.setUsers(users);
        JAXBContext context = JAXBContext.newInstance(conexionXMLUsuario.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(wrapper, archivo);

    }

    /**
     * Añade un usuario nuevo a la list
     * @param user usuario nuevo
     * @throws Exception
     */
    public void añadirUsuario(User user) throws Exception {
        List<User> usuarios = getUsers();
        usuarios.add(user);
        try {
            guardarUsuario(usuarios);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }   


    }

    public List<User> getUsers() throws Exception {
        if (archivo.exists()) {
            // Si el archivo existe, deserializar los usuarios desde el archivo XML
            JAXBContext context = JAXBContext.newInstance(conexionXMLUsuario.class);
            Unmarshaller um = context.createUnmarshaller();
            conexionXMLUsuario wrapper = (conexionXMLUsuario) um.unmarshal(archivo);
            return wrapper.getUsers();
        } else {
            // Si no existe el archivo, crearlo e inicializarlo con una lista vacía
            crearXMLInicial();
            return new ArrayList<>();
        }
    }

    /**
     * Crea el archivo xml
     * @throws Exception
     */
    public void crearXMLInicial() throws Exception {
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        conexionXMLUsuario wrapper = new conexionXMLUsuario();
        wrapper.setUsers(new ArrayList<>());
        JAXBContext context = JAXBContext.newInstance(conexionXMLUsuario.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(wrapper, archivo);
    }
}