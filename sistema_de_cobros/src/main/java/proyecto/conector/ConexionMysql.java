package proyecto.conector;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionMysql {

   private static final String URL = "jdbc:mysql://localhost:3306/crediya_db";
   private static final String USER = "root";
   private static final String PASSWORD = "quiopro123";

   public static Connection conectar(){
      Connection conexion = null;
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conexion = DriverManager.getConnection(URL, USER, PASSWORD);
         JOptionPane.showMessageDialog(null,"CONEXION EXITOSA");
      } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "HUBO ERROR EN LA CONEXION EN LA BASE DE DATOS ");
         e.printStackTrace();
      }
      return conexion;
   }

}
