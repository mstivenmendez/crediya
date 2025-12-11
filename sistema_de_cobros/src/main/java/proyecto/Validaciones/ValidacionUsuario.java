package proyecto.validaciones;

import proyecto.conector.ConexionDB;
import java.sql.*;

public class ValidacionUsuario {

   private Connection db;

   // Constructor para establecer la conexión a la base de datos
   public ValidacionUsuario() {
      try {
         db = ConexionDB.conectar();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   /**
    * Valida las credenciales de un usuario en la base de datos
    * 
    * @param correo Correo del usuario
    * @param clave  Contraseña del usuario
    * @return true si las credenciales son válidas, false en caso contrario
    */
   public boolean validarUsuario(String correo, String clave) {
      String sql = "SELECT * FROM usuario WHERE correo = ? AND clave = ? AND estado = 'activo'";

      try (PreparedStatement stmt = db.prepareStatement(sql)) {
         stmt.setString(1, correo);
         stmt.setString(2, clave);

         ResultSet rs = stmt.executeQuery();

         if (rs.next()) {
            return true; // Credenciales correctas
         } else {
            return false; // Credenciales incorrectas
         }

      } catch (SQLException e) {
         e.printStackTrace();
         return false;
      }
   }

   /**
    * Obtiene el rol de un usuario
    * 
    * @param correo Correo del usuario
    * @return ID del rol (1=Admin, 2=Cliente, 3=Empleado) o 0 si no se encuentra
    */
   public int obtenerRolUsuario(String correo) {
      String sql = "SELECT ur.rol_id_fk " +
            "FROM usuario u " +
            "INNER JOIN usuario_rol ur ON u.usuario_id = ur.usuario_id_fk " +
            "WHERE u.correo = ?";

      try (PreparedStatement stmt = db.prepareStatement(sql)) {
         stmt.setString(1, correo);
         ResultSet rs = stmt.executeQuery();

         if (rs.next()) {
            return rs.getInt("rol_id_fk");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return 0; // No se encontró rol
   }

   /**
    * Obtiene el ID del usuario por correo
    * 
    * @param correo Correo del usuario
    * @return ID del usuario o 0 si no se encuentra
    */
   public int obtenerUsuarioId(String correo) {
      String sql = "SELECT usuario_id FROM usuario WHERE correo = ?";

      try (PreparedStatement stmt = db.prepareStatement(sql)) {
         stmt.setString(1, correo);
         ResultSet rs = stmt.executeQuery();

         if (rs.next()) {
            return rs.getInt("usuario_id");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return 0;
   }

   /**
    * Obtiene información completa del usuario
    * 
    * @param correo Correo del usuario
    * @return Array con [usuario_id, nombre_completo, documento, rol_nombre] o null
    */
   public String[] obtenerInformacionUsuario(String correo) {
      String sql = "SELECT u.usuario_id, " +
            "CONCAT(i.primer_nombre, ' ', IFNULL(i.segundo_nombre, ''), ' ', " +
            "i.primer_apellido, ' ', IFNULL(i.segundo_apellido, '')) as nombre_completo, " +
            "i.documento, r.nombre as rol_nombre " +
            "FROM usuario u " +
            "INNER JOIN informacion i ON u.usuario_id = i.usuario_id_fk " +
            "INNER JOIN usuario_rol ur ON u.usuario_id = ur.usuario_id_fk " +
            "INNER JOIN rol r ON ur.rol_id_fk = r.rol_id " +
            "WHERE u.correo = ?";

      try (PreparedStatement stmt = db.prepareStatement(sql)) {
         stmt.setString(1, correo);
         ResultSet rs = stmt.executeQuery();

         if (rs.next()) {
            return new String[] {
                  String.valueOf(rs.getInt("usuario_id")),
                  rs.getString("nombre_completo").trim(),
                  rs.getString("documento"),
                  rs.getString("rol_nombre")
            };
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return null;
   }

   /**
    * Verifica si un correo ya está registrado
    * 
    * @param correo Correo a verificar
    * @return true si el correo existe, false si no
    */
   public boolean correoExiste(String correo) {
      String sql = "SELECT COUNT(*) as total FROM usuario WHERE correo = ?";

      try (PreparedStatement stmt = db.prepareStatement(sql)) {
         stmt.setString(1, correo);
         ResultSet rs = stmt.executeQuery();

         if (rs.next()) {
            return rs.getInt("total") > 0;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }

   /**
    * Verifica si un documento ya está registrado
    * 
    * @param documento Documento a verificar
    * @return true si el documento existe, false si no
    */
   public boolean documentoExiste(String documento) {
      String sql = "SELECT COUNT(*) as total FROM informacion WHERE documento = ?";

      try (PreparedStatement stmt = db.prepareStatement(sql)) {
         stmt.setString(1, documento);
         ResultSet rs = stmt.executeQuery();

         if (rs.next()) {
            return rs.getInt("total") > 0;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }

   /**
    * Cierra la conexión a la base de datos
    */
   public void cerrarConexion() {
      try {
         if (db != null && !db.isClosed()) {
            db.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}