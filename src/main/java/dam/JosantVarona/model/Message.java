package dam.JosantVarona.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name = "mensaje")
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
    @XmlElement
    public User receptor;
    @XmlElement
    public User emisor;
    @XmlElement
    public String contenido;
    public LocalDateTime horafecha;

    public Message() {

    }

    public Message(User receptor, User emisor, String mensaje, LocalDateTime horafecha) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.contenido = mensaje;
        this.horafecha = horafecha;
    }

    public Message(User receptor, User emisor, String contenido) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.contenido = contenido;
    }

    public User getReceptor() {
        return receptor;
    }

    public void setReceptor(User receptor) {
        this.receptor = receptor;
    }

    public User getEmisor() {
        return emisor;
    }

    public void setEmisor(User emisor) {
        this.emisor = emisor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getHorafecha() {
        return horafecha;
    }

    public void setHorafecha(LocalDateTime horafecha) {
        this.horafecha = horafecha;
    }
}
