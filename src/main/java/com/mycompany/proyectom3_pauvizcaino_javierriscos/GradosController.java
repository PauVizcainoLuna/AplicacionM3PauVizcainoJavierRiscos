/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectom3_pauvizcaino_javierriscos;

import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import modelo.GestioDades;
import modelo.Grados;

/**
 *
 * @author PauVizcaino
 */
public class GradosController {

    //Iniciamos la conexion con la base de datos
    GestioDades gestio = new GestioDades();

    //Inicializamos los elementos del FXML
    @FXML
    private TextField gradosColor;
    @FXML
    private TableView<Grados> tablaGrados;
    @FXML
    private TableColumn<Grados, Integer> idGrados;
    @FXML
    private TableColumn<Grados, String> colorGrados;
    @FXML
    private Tooltip Modificar;
    @FXML
    private Tooltip Añadir;
    @FXML
    private Tooltip Eliminar;

    public void initialize() throws SQLException {
        idGrados.setCellValueFactory(new PropertyValueFactory("id_grado"));
        colorGrados.setCellValueFactory(new PropertyValueFactory<>("color"));
        tablaGrados.setItems(gestio.llistaGrados());
        Modificar.setShowDelay(Duration.ONE);
        Añadir.setShowDelay(Duration.ONE);
        Eliminar.setShowDelay(Duration.ONE);
    }

    //---------------------------------------------------------------------------------------------------------------------------

    public void tornarEnrere() throws IOException {
        App.setRoot("Eleccion");
    }

    //---------------------------------------------------------------------------------------------------------------------------
    //Metodo para añadir grados desde afegirgrados de GestioDades
    public void AfegirGrados() throws SQLException {
        try {
            // Verificar si algun campo esta vacio
            if (gradosColor.getText().isEmpty()) {
                // Mensaje de error si no se han completado todos los campos
                gestio.mostrarAlertWarning("ERROR: Debes completar el campo de color.");
            } else {
                Grados grados = new Grados(gestio.generarIdGrados(),
                        gradosColor.getText());
                gestio.AfegirGrados(grados);

                //Dejamos en blanco el textfield
                gradosColor.setText("");

            }
        } catch (Exception e) {
            gestio.mostrarAlertWarning("ERROR: " + e.getMessage());
        }

        //Actualizar tabla automáticamente
        tablaGrados.getItems().clear();
        tablaGrados.setItems(gestio.llistaGrados());
    }

    //---------------------------------------------------------------------------------------------------------------------------
    //Metodo para eliminar grados desde eliminarGrados de GestioDades
    public void eliminarGrados() throws SQLException {
        try {
            if (tablaGrados.getSelectionModel().getSelectedItem() != null) {
                gestio.eliminarGrados(tablaGrados.getSelectionModel().getSelectedItem().getId_grado());
                //Dejamos en blanco el textfield

            } else {
                // Mensaje de error si no se ha seleccionado ningún grado
                gestio.mostrarAlertWarning("ERROR: Debes seleccionar un grado.");
            }
        } catch (Exception e) {
            gestio.mostrarAlertWarning("ERROR: " + e.getMessage());
        }

        // Actualizar tabla automáticamente
        tablaGrados.getItems().clear();
        tablaGrados.setItems(gestio.llistaGrados());
    }

    //---------------------------------------------------------------------------------------------------------------------------
    //Metodo para modificar grados a traves del metodo de modifcarGrados de GestioDades
    public void modificarGrados() throws SQLException {
        try {
            Grados gradoSeleccionat = tablaGrados.getSelectionModel().getSelectedItem();

            // Verificar si hay un grado seleccionado y el campo no está vacío
            if (gradoSeleccionat != null && !gradosColor.getText().isEmpty()) {
                gestio.modificarGrados(gradoSeleccionat.getId_grado(),
                        gradosColor.getText());
                //Dejamos en blanco el textfield
                gradosColor.setText("");

            } else {
                // Mensaje de error si no se han completado todos los campos
                gestio.mostrarAlertWarning("ERROR: Debes seleccionar un grado y completar el campo de color.");
            }
        } catch (Exception e) {
            gestio.mostrarAlertWarning("ERROR: " + e.getMessage());
        }

        // Actualizar tabla automáticamente
        tablaGrados.getItems().clear();
        tablaGrados.setItems(gestio.llistaGrados());
    }

}
