/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Conexion.conexion;
import Ventanas.Ventana;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author tere
 */
public class Registros extends Application {
   @Override
    public void start(Stage primaryStage) throws Exception {
    
        Ventana ven = new Ventana();
        ven.setVisible(true);

    
    }
    public static void main(String[] args) {
        launch(args);
    }

    
    
}
