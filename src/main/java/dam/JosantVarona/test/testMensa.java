package dam.JosantVarona.test;

import dam.JosantVarona.model.Gestionmensajes;
import dam.JosantVarona.model.Message;
import dam.JosantVarona.model.User;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class testMensa {
    public static void main(String[] args) throws JAXBException {
        LocalDateTime ahora = LocalDateTime.now();
        Gestionmensajes mesajes = new Gestionmensajes();
        User emisor = new User("user1","password1");
        User receptor = new User("josant","HOLA");
        /*Message mensaje = new Message(emisor,receptor,"hola");
        mesajes.enviarMensakes(mensaje);

        /*List<Message> archivo = mesajes.getMensajes(emisor,receptor);
        for (Message message:archivo){
            System.out.println(message.contenido);
        }*/
    }
}
