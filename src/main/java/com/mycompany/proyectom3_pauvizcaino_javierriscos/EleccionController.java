package com.mycompany.proyectom3_pauvizcaino_javierriscos;

import java.io.IOException;
import javafx.fxml.FXML;
import modelo.Connexio;

public class EleccionController {

    Connexio connexio = new Connexio();

    //Para entrar en alumnos
    @FXML
    private void seguentAlumne() throws IOException {
        App.setRoot("Alumne");
    }

    //Para entrar en profesores
    @FXML
    private void seguentProfessor() throws IOException {
        App.setRoot("Professors");
    }

    //Para entrar en clases
    @FXML
    private void seguentClasse() throws IOException {
        App.setRoot("Clases");
    }
    
    //Para entrar en grados
    @FXML
    private void seguentGrado()throws IOException{
       App.setRoot("Grados");
    }

    //Para salir de la App mediante el metodo, ya que hemos anulado el evento de cerrar ventana
    @FXML
    private void salirApp() throws IOException {
        connexio.mensajeConfirmar();
    }
    
    
}
