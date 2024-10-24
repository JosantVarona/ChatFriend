package dam.JosantVarona.Datos;

import dam.JosantVarona.model.Message;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "mensajes")
    public class mensajesXML {
    private List<Message> mesajes = new ArrayList<>();
    @XmlElement(name = "mensaje")
    public List<Message>getMesaje(){
        return mesajes;
    }
    public void setMesajes(List<Message> mesajes){
        this.mesajes = mesajes;
    }
}
