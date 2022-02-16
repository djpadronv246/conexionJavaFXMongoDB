/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utl.conexionjavafxmongo.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import utl.conexionjavafxmongo.core.Conexion;

/**
 *
 * @author Dulce Padron
 */
public class ConexionController {

    @FXML
    private JFXButton btnLimpiar;

    @FXML
    private JFXButton btnConectar;

    @FXML
    private JFXButton btnCrear;

    @FXML
    private JFXTextField txtNuevoRegistro;

    @FXML
    private TextArea txtCodigo;

    @FXML
    private JFXButton btnActualizar;

    @FXML
    private JFXButton btnEliminar;

    @FXML
    private JFXTextField txtReemplazo;


    public void initialize(URL url, ResourceBundle rb) {

    }
    String nombre = "";
    String nombreNuevo = "";
    String nombreViejo = "";

    public void Conectar() {
        Conexion conec = new Conexion();

        txtCodigo.setText(conec.Mostrar());
    }

    public void Insertar() {

        Conexion conec = new Conexion();
        nombre = txtNuevoRegistro.getText();
        conec.insertar(nombre);
        txtCodigo.setText(conec.Mostrar());

    }

    public void Actualizar() {
        Conexion conec = new Conexion();
        nombreViejo = txtReemplazo.getText();
        nombreNuevo = txtNuevoRegistro.getText();
        conec.Actualizar(nombreViejo, nombreNuevo);
        txtCodigo.setText(conec.Mostrar());
    }

    public void Eliminar() {
        Conexion conec = new Conexion();
        nombre = txtReemplazo.getText();
        conec.Eliminar(nombre);
        txtCodigo.setText(conec.Mostrar());
    }

    public void Limpiar() {
        txtCodigo.setText("");
    }
}
