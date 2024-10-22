package dam.JosantVarona.model;

import java.time.LocalDateTime;

public class Message {
    private User receptor;
    private User emisor;
    private String mensaje;
    private LocalDateTime horafecha;

    public Message(User receptor, User emisor, String message) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.mensaje = message;
    }

    public Message(User receptor, User emisor, String mensaje, LocalDateTime horafecha) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.mensaje = mensaje;
        this.horafecha = horafecha;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getHorafecha() {
        return horafecha;
    }

    public void setHorafecha(LocalDateTime horafecha) {
        this.horafecha = horafecha;
    }
}
