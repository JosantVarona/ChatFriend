package dam.JosantVarona.model;

public class Message {
    private User receptor;
    private User emisor;
    private String message;

    public Message(User receptor, User emisor, String message) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.message = message;
    }

    public User getReceptor() {
        return receptor;
    }

    public void setReceptor(User receptor) {
        this.receptor = receptor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getEmisor() {
        return emisor;
    }

    public void setEmisor(User emisor) {
        this.emisor = emisor;
    }
}
