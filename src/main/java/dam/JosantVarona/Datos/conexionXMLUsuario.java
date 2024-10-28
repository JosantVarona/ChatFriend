package dam.JosantVarona.Datos;

import dam.JosantVarona.model.User;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

//Esta clase es para hacer elemento raiz users del xml
@XmlRootElement (name = "users")
public class conexionXMLUsuario {
        private List<User> users = new ArrayList<>();
        @XmlElement (name = "user")
        public List<User> getUsers() {
            return users;
        }
        public void setUsers(List<User> users) {
            this.users = users;
        }
}
