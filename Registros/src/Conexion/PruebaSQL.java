/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
public class PruebaSQL extends Application {
    
    @Override
    public void start(Stage primaryStage) throws SQLException{
      
    String dbURL = "jdbc:postgresql://172.16.0.58:5432/deportes";
    String user = "cliente";
    String pass = "12345";
    
  
    Connection conn = DriverManager.getConnection(dbURL, user, pass);
        System.out.println("conexion exitosa");
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
