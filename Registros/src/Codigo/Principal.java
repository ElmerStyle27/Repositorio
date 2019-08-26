/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;
//MOdificado

import Conexion.conexion;
import Conexion.conexion1;
import Ventanas.Ventana;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlos
 */
public class Principal {

    Connection conn = conexion1.getConexion();
    

    public void Consultar(JTable ta, String nom) {
        try {
            Class.forName("org.postgresql.Driver");
            DefaultTableModel model = (DefaultTableModel) ta.getModel();
            model.setRowCount(0);//incializa la tabla desde la fila 0
            try (
                    //  Connection conn = DriverManager.getConnection(conexion.dbURL, conexion.user, conexion.pass);
                    Statement comando = conn.createStatement()) {
                String sql = "select * from registros where nombre like '%" + nom + "%'";
                ResultSet resultado = comando.executeQuery(sql);
                while (resultado.next()) {
                    Vector v = new Vector();
                    v.add(resultado.getString(1));
                    v.add(resultado.getString(2));
                    v.add(resultado.getString(3));
                    v.add(resultado.getString(4));
                    model.addRow(v);

                    ta.setModel(model);
                }
                resultado.close();
            }
        } catch (Exception e) {
            System.out.println("Error de conexion 10000" + e.getMessage());
        }
    }

    public void Eliminar(String nom, String ed, String co, String de) {

        try {
            
            Statement st;
            Class.forName("org.postgresql.Driver");
            // Connection conn = DriverManager.getConnection(conexion.dbURL, conexion.user, conexion.pass);
            String nom2, ed2, co2, de2;
            CallableStatement cs = conn.prepareCall("select eliminar ('" + nom + "','"
                    + Integer.valueOf(ed) + "','"
                    + co + "','"
                    + de + "');");

            //CallableStatement acc = conn.prepareCall(instruccion);
//            PreparedStatement acc = conn.prepareStatement(instruccion);
//            acc.executeUpdate();
            cs.executeQuery();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            //conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e);
        }

    }

    public void Registrar(String nom, String ed, String co, String de) {
        try {

            Statement st;
            Class.forName("org.postgresql.Driver");
            // Connection conn = DriverManager.getConnection(conexion.dbURL, conexion.user, conexion.pass);

            st = conn.createStatement();
//            String tsql = "INSERT INTO registros(nombre, edad, color, deporte) values ('"
//                    + nom + "', "
//                    + Integer.valueOf(ed) + ", '"
//                    + co + "', '"
//                    + de + "');";
            //String tsql = 
            CallableStatement cs = conn.prepareCall("select insertar ('" + nom + "', "
                    + Integer.valueOf(ed) + ", '"
                    + co + "', '"
                    + de + "');");

            cs.executeQuery();
            JOptionPane.showMessageDialog(null, "Registro Insertado");
            //   conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update(String Nom2, String ed2, String co2, String de2, String nom, String ed, String co, String de) {
        try {
            Statement st;
            Class.forName("org.postgresql.Driver");
            // Connection conn = DriverManager.getConnection(conexion.dbURL, conexion.user, conexion.pass);

            //String instruccion = "update registros set " + "edad=?," + "color=?," + " deporte=?" + " where nombre='" + nom + "'";
            CallableStatement cs = conn.prepareCall("select modificar ('" + Nom2 + "',"+  Integer.valueOf(ed2) + ",'" +co2+"','"+de2+"','"+ nom + "',"+  Integer.valueOf(ed) + ",'" +co+"','"+de+"');");
            //PreparedStatement act = conn.prepareStatement(instruccion);)
            cs.executeQuery();
            int eda = Integer.valueOf(ed);

//            act.setInt(1, eda);
//            act.setString(2, co);
//            act.setString(3, de);
//
//            act.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro actualizado ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar " + e);
        }

    }

}
