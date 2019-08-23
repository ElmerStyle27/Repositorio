
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.singleton;
import java.util.Properties;

    public class conexion1 {
     
        //Instancia estatica de la conexion, sino uno llega a existir
        public static Connection connection = null;
     
        /**
         *
         * @return Devuelve la instancia unica de Conexion
         */
        public static Connection getConexion() {
            //Si la instancia no ha sido creado aun, se crea
            if (conexion1.connection == null) {
                contruyendoConexion();
            }
            return conexion1.connection;
        }
     
        //Obtener las instancias de Conexion JDBC
        private static void contruyendoConexion() {
            //SingletonProperties con=SingletonProperties.getConexion();
            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://172.16.0.102:5432/sistemaventas";
                String usuario = "cl1";
                String clave = "12345";
                conexion1.connection = DriverManager.getConnection(url, usuario, clave);
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException(contruyendoConexion)  : " + e.getMessage());
                System.gc();
            } catch (SQLException e) {
                System.out.println("SQLException(contruyendoConexion) : " + e.getMessage());
                System.gc();
            } catch (Exception e) {
                System.out.println(" Exception General (contruyendoConexion) : " + e.getMessage());
                System.gc();
            }
        }

    }