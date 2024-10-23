package dam.JosantVarona;

import dam.JosantVarona.view.AppController;
import dam.JosantVarona.view.Controller;
import dam.JosantVarona.view.Scenes;
import dam.JosantVarona.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Scene scene;
    public static Stage stage;
    public static AppController currenController;
    //pantalla principal

    @Override
    public void start(Stage stage) throws IOException {
        View view = AppController.loadFXML(Scenes.ROOT);
        scene = new Scene(view.scene,1000, 500);
        currenController = (AppController) view.controller;
        currenController.onOpen(null);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        //scene.setRoot(loadFXML(fxml));
    }

    public static void main(String[] args) {
        launch();
    }

}