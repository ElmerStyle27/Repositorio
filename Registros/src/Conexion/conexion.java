package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class conexion {

    public static String dbURL = "jdbc:postgresql://172.16.0.102:5432/sistemaventas";
    public static String user = "cl1";
    public static String pass = "12345";

    public void Tete() throws SQLException {
        Connection conn = DriverManager.getConnection(dbURL, user, pass);
    }

}
