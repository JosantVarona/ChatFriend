package dam.JosantVarona.test;

import dam.JosantVarona.Datos.conexionXMLUsuario;
import dam.JosantVarona.Datos.usuariosXML;
import dam.JosantVarona.model.User;
import dam.JosantVarona.utils.XMLManager;

import java.util.List;

public class prueba {

    public static void main(String[] args) throws Exception {
        usuariosXML patata = new usuariosXML();
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");

        patata.añadirUsuario(user1);
        patata.añadirUsuario(user2);

        List<User> users = patata.getUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }
}
