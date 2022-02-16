/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utl.conexionjavafxmongo.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Dulce Padron
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/utl/conexionjavafxmongo/gui/fxml/conexion.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("org/kordamp/bootstrapfx/bootstrapfx.css");
        primaryStage.setTitle("Conexion Java-MongoDB");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        Alert bienvenida = new Alert(Alert.AlertType.INFORMATION, "Bienvenido");
        bienvenida.showAndWait();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Conexion Exitosa");
        alert.showAndWait();
    }
}
