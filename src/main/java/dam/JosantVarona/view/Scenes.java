package dam.JosantVarona.view;

//Clase Para las url de los fxml
public enum Scenes {
    ROOT("view/layout.fxml"),
    STAR("view/star.fxml"),
    LOGIN("view/login.fxml"),
    MAIN("view/main.fxml"),
    CHAT("view/chat.fxml");

    private String url;
    Scenes (String url){
        this.url = url;
    }
    public String getURL(){
        return url;
    }
}
