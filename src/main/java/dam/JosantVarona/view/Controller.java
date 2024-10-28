package dam.JosantVarona.view;

import dam.JosantVarona.App;

import java.io.IOException;

//Clase abtrata para los metodos que tiene que tener los controladores
public abstract class Controller {
    App app;
    public void setApp(App app){
        this.app=app;
    }
    public abstract void onOpen(Object input) throws Exception;
    public abstract void onClose(Object output);

}
