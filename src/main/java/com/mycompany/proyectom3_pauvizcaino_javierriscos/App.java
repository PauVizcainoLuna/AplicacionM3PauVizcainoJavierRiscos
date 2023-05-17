package com.mycompany.proyectom3_pauvizcaino_javierriscos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 655, 770);
        Image image = new Image("/com/mycompany/proyectom3_pauvizcaino_javierriscos/images/logojiuborde.png");//Creamos nuevo IMAGE donde ponemos nuestra imagen que utilizaremos para el icono
        stage.getIcons().add(image);//Añadimos el icono con el metodo de getIcons
        stage.setTitle("P&J BRAZILIAN JIU-JITSU");//Ponemos un nombre para mostrar al ejecutar el programa
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        //Para bloquear el evento de cerrar pantalla desde la x del menu 
        stage.setOnCloseRequest(event -> {
            event.consume(); // Anula el evento predeterminado de cierre de ventana
        });
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
