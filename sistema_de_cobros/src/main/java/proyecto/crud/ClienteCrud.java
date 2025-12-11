package proyecto.crud;

import javax.swing.JOptionPane;
import proyecto.util.IngresoDatos;
import proyecto.validaciones.Validacion;
import proyecto.conector.ConexionDB;
import proyecto.personal.Cliente;
import proyecto.prestamo.Estado;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClienteCrud implements CrudEntity<Cliente> {

   private IngresoDatos conexion = new IngresoDatos();
   private Validacion validacion = new Validacion();

   @Override
   public int Guardar(Cliente entity, String sql) {
      Connection conn = null;
      PreparedStatement psUsuario = null;
      PreparedStatement psInformacion = null;
      PreparedStatement psUsuarioRol = null;
      ResultSet generatedKeys = null;

      try {
         conn = ConexionDB.conectar();
         conn.setAutoCommit(false); // Iniciar transacción

         // ========== SOLICITAR DATOS ==========
         
         String correo = JOptionPane.showInputDialog("Ingrese el correo:");
         if (correo == null) return 0;
         correo = validacion.ValidarEmail(correo);
         if (correo == null) return 0;

         String clave = JOptionPane.showInputDialog(
            "Ingrese la contraseña:\n" +
            "(Min 8 caracteres, mayúscula, minúscula, número y símbolo)");
         if (clave == null) return 0;
         clave = validacion.ValidarClave(clave);
         if (clave == null) return 0;

         String nombre = JOptionPane.showInputDialog("Ingrese el primer nombre:");
         if (nombre == null) return 0;
         nombre = validacion.ValidarTexto(nombre);
         if (nombre == null) return 0;

         String nombre2 = JOptionPane.showInputDialog("Ingrese el segundo nombre (opcional):");
         if (nombre2 != null && !nombre2.trim().isEmpty()) {
            nombre2 = validacion.ValidarTexto(nombre2);
         } else {
            nombre2 = null;
         }

         String apellido = JOptionPane.showInputDialog("Ingrese el primer apellido:");
         if (apellido == null) return 0;
         apellido = validacion.ValidarTexto(apellido);
         if (apellido == null) return 0;

         String apellido2 = JOptionPane.showInputDialog("Ingrese el segundo apellido (opcional):");
         if (apellido2 != null && !apellido2.trim().isEmpty()) {
            apellido2 = validacion.ValidarTexto(apellido2);
         } else {
            apellido2 = null;
         }

         String documento = JOptionPane.showInputDialog("Ingrese el documento (7-11 dígitos):");
         if (documento == null) return 0;
         documento = validacion.ValidarDocumento(documento);
         if (documento == null) return 0;

         String telefono = JOptionPane.showInputDialog("Ingrese el teléfono (10 dígitos):");
         if (telefono == null) return 0;
         telefono = validacion.ValidarTelefonoU(telefono);
         if (telefono == null) return 0;

         String salarioStr = JOptionPane.showInputDialog("Ingrese el salario (opcional):");
         Double salario = null;
         if (salarioStr != null && !salarioStr.trim().isEmpty()) {
            try {
               salario = Double.parseDouble(salarioStr);
            } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "Salario inválido, se omitirá este campo.");
            }
         }

         // ========== PASO 1: INSERTAR EN TABLA USUARIO ==========
         
         String sqlUsuario = "INSERT INTO usuario (correo, clave, estado, fecha_creacion) VALUES (?, ?, 'activo', NOW())";
         psUsuario = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
         psUsuario.setString(1, correo);
         psUsuario.setString(2, clave);
         
         int filasUsuario = psUsuario.executeUpdate();
         
         if (filasUsuario == 0) {
            conn.rollback();
            JOptionPane.showMessageDialog(null, "Error al registrar usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
         }

         // Obtener el usuario_id generado
         generatedKeys = psUsuario.getGeneratedKeys();
         int usuarioId = 0;
         if (generatedKeys.next()) {
            usuarioId = generatedKeys.getInt(1);
         } else {
            conn.rollback();
            JOptionPane.showMessageDialog(null, "Error al obtener ID de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
         }

         // ========== PASO 2: INSERTAR EN TABLA INFORMACION ==========
         
         String sqlInformacion = "INSERT INTO informacion (usuario_id_fk, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, documento, telefono, salario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
         psInformacion = conn.prepareStatement(sqlInformacion);
         psInformacion.setInt(1, usuarioId);
         psInformacion.setString(2, nombre);
         psInformacion.setString(3, nombre2);
         psInformacion.setString(4, apellido);
         psInformacion.setString(5, apellido2);
         psInformacion.setString(6, documento);
         psInformacion.setString(7, telefono);
         if (salario != null) {
            psInformacion.setDouble(8, salario);
         } else {
            psInformacion.setNull(8, Types.DECIMAL);
         }
         
         int filasInformacion = psInformacion.executeUpdate();
         
         if (filasInformacion == 0) {
            conn.rollback();
            JOptionPane.showMessageDialog(null, "Error al registrar información.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
         }

         // ========== PASO 3: ASIGNAR ROL DE CLIENTE ==========
         
         // Asumiendo que rol_id = 2 es para clientes (ajusta según tu BD)
         String sqlUsuarioRol = "INSERT INTO usuario_rol (usuario_id_fk, rol_id_fk) VALUES (?, 2)";
         psUsuarioRol = conn.prepareStatement(sqlUsuarioRol);
         psUsuarioRol.setInt(1, usuarioId);
         
         int filasRol = psUsuarioRol.executeUpdate();
         
         if (filasRol == 0) {
            conn.rollback();
            JOptionPane.showMessageDialog(null, "Error al asignar rol.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
         }

         // ========== COMMIT DE LA TRANSACCIÓN ==========
         
         conn.commit();
         
         JOptionPane.showMessageDialog(null,
            "✅ Cliente registrado exitosamente\n\n" +
            "ID Usuario: " + usuarioId + "\n" +
            "Correo: " + correo + "\n" +
            "Documento: " + documento,
            "Registro Exitoso",
            JOptionPane.INFORMATION_MESSAGE);

         return usuarioId;

      } catch (SQLException e) {
         // Rollback en caso de error
         if (conn != null) {
            try {
               conn.rollback();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
         }
         
         String errorMsg = e.getMessage();
         if (errorMsg.contains("Duplicate entry")) {
            if (errorMsg.contains("correo")) {
               JOptionPane.showMessageDialog(null, "❌ El correo ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (errorMsg.contains("documento")) {
               JOptionPane.showMessageDialog(null, "❌ El documento ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
         } else {
            JOptionPane.showMessageDialog(null, "Error al registrar: " + errorMsg, "Error", JOptionPane.ERROR_MESSAGE);
         }
         e.printStackTrace();
         return 0;

      } finally {
         // Cerrar recursos
         try {
            if (generatedKeys != null) generatedKeys.close();
            if (psUsuarioRol != null) psUsuarioRol.close();
            if (psInformacion != null) psInformacion.close();
            if (psUsuario != null) psUsuario.close();
            if (conn != null) {
               conn.setAutoCommit(true);
               conn.close();
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

   @Override
   public List<Cliente> Buscar() {
      List<Cliente> clientes = new ArrayList<>();
      String sql = "SELECT u.usuario_id, u.correo, u.estado, u.fecha_creacion, " +
                   "i.primer_nombre, i.segundo_nombre, i.primer_apellido, i.segundo_apellido, " +
                   "i.documento, i.telefono, i.salario " +
                   "FROM usuario u " +
                   "INNER JOIN informacion i ON u.usuario_id = i.usuario_id_fk " +
                   "INNER JOIN usuario_rol ur ON u.usuario_id = ur.usuario_id_fk " +
                   "WHERE ur.rol_id_fk = 2"; // 2 = rol cliente

      try (Connection conn = ConexionDB.conectar();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql)) {

         while (rs.next()) {
            Cliente cliente = new Cliente();
            
            // Datos de usuario
            cliente.setIdCliente(String.valueOf(rs.getInt("usuario_id")));
            cliente.setCorreo(rs.getString("correo"));
            
            String estadoBD = rs.getString("estado");
            if ("activo".equalsIgnoreCase(estadoBD)) {
               cliente.setEstado(Estado.ACTIVO);
            } else {
               cliente.setEstado(Estado.INACTIVO);
            }
            
            // Datos de información
            cliente.setNombre(rs.getString("primer_nombre"));
            cliente.setNombre2(rs.getString("segundo_nombre"));
            cliente.setApellido(rs.getString("primer_apellido"));
            cliente.setApellido2(rs.getString("segundo_apellido"));
            cliente.setDocumento(rs.getString("documento"));
            cliente.setTelefono(rs.getString("telefono"));
            
            clientes.add(cliente);
         }

         if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron clientes en la base de datos.");
         }

      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error al buscar clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
      }

      return clientes;
   }

   @Override
   public int BuscarPor(Object[] args) {
      String criterio = JOptionPane.showInputDialog("Ingrese el documento del cliente a buscar:");
      if (criterio == null || criterio.trim().isEmpty()) return 0;

      String sql = "SELECT u.usuario_id, u.correo, u.estado, " +
                   "i.primer_nombre, i.segundo_nombre, i.primer_apellido, i.segundo_apellido, " +
                   "i.documento, i.telefono, i.salario " +
                   "FROM usuario u " +
                   "INNER JOIN informacion i ON u.usuario_id = i.usuario_id_fk " +
                   "WHERE i.documento = ?";

      try (Connection conn = ConexionDB.conectar();
           PreparedStatement ps = conn.prepareStatement(sql)) {

         ps.setString(1, criterio);
         ResultSet rs = ps.executeQuery();

         if (rs.next()) {
            String info = "=== CLIENTE ENCONTRADO ===\n\n" +
                         "ID Usuario: " + rs.getInt("usuario_id") + "\n" +
                         "Nombre: " + rs.getString("primer_nombre") + " " + 
                                    (rs.getString("segundo_nombre") != null ? rs.getString("segundo_nombre") + " " : "") +
                                    rs.getString("primer_apellido") + " " + 
                                    (rs.getString("segundo_apellido") != null ? rs.getString("segundo_apellido") : "") + "\n" +
                         "Correo: " + rs.getString("correo") + "\n" +
                         "Documento: " + rs.getString("documento") + "\n" +
                         "Teléfono: " + rs.getString("telefono") + "\n" +
                         "Salario: " + (rs.getDouble("salario") > 0 ? "$" + rs.getDouble("salario") : "No registrado") + "\n" +
                         "Estado: " + rs.getString("estado").toUpperCase();

            JOptionPane.showMessageDialog(null, info, "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
            return rs.getInt("usuario_id");
         } else {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ese documento.");
            return 0;
         }

      } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
         return 0;
      }
   }

   @Override
   public int Actualizar(Cliente entity, int id, String dato) {
      String documento = JOptionPane.showInputDialog("Ingrese el documento del cliente a actualizar:");
      if (documento == null || documento.trim().isEmpty()) return 0;

      Connection conn = null;
      PreparedStatement psUsuario = null;
      PreparedStatement psInformacion = null;

      try {
         conn = ConexionDB.conectar();
         conn.setAutoCommit(false);

         // Buscar el usuario_id
         String sqlBuscar = "SELECT u.usuario_id, u.correo, u.estado, " +
                           "i.telefono, i.salario " +
                           "FROM usuario u " +
                           "INNER JOIN informacion i ON u.usuario_id = i.usuario_id_fk " +
                           "WHERE i.documento = ?";
         
         PreparedStatement psBuscar = conn.prepareStatement(sqlBuscar);
         psBuscar.setString(1, documento);
         ResultSet rs = psBuscar.executeQuery();

         if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            return 0;
         }

         int usuarioId = rs.getInt("usuario_id");
         String datosActuales = "=== DATOS ACTUALES ===\n\n" +
                               "Correo: " + rs.getString("correo") + "\n" +
                               "Teléfono: " + rs.getString("telefono") + "\n" +
                               "Salario: " + (rs.getDouble("salario") > 0 ? "$" + rs.getDouble("salario") : "No registrado") + "\n" +
                               "Estado: " + rs.getString("estado").toUpperCase();

         JOptionPane.showMessageDialog(null, datosActuales);
         rs.close();
         psBuscar.close();

         // Solicitar nuevos datos
         String telefono = JOptionPane.showInputDialog("Nuevo teléfono:");
         if (telefono == null) return 0;
         telefono = validacion.ValidarTelefonoU(telefono);
         if (telefono == null) return 0;

         String correo = JOptionPane.showInputDialog("Nuevo correo:");
         if (correo == null) return 0;
         correo = validacion.ValidarEmail(correo);
         if (correo == null) return 0;

         String[] estadoOpciones = {"activo", "inactivo"};
         String estadoStr = (String) JOptionPane.showInputDialog(null, 
            "Seleccione el nuevo estado:",
            "Estado",
            JOptionPane.QUESTION_MESSAGE,
            null,
            estadoOpciones,
            estadoOpciones[0]);
         
         if (estadoStr == null) return 0;

         // Actualizar usuario
         String sqlUsuario = "UPDATE usuario SET correo = ?, estado = ? WHERE usuario_id = ?";
         psUsuario = conn.prepareStatement(sqlUsuario);
         psUsuario.setString(1, correo);
         psUsuario.setString(2, estadoStr);
         psUsuario.setInt(3, usuarioId);
         psUsuario.executeUpdate();

         // Actualizar información
         String sqlInformacion = "UPDATE informacion SET telefono = ? WHERE usuario_id_fk = ?";
         psInformacion = conn.prepareStatement(sqlInformacion);
         psInformacion.setString(1, telefono);
         psInformacion.setInt(2, usuarioId);
         psInformacion.executeUpdate();

         conn.commit();

         JOptionPane.showMessageDialog(null, "¡Cliente actualizado exitosamente!");
         return 1;

      } catch (SQLException e) {
         if (conn != null) {
            try {
               conn.rollback();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
         }
         JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
         return 0;

      } finally {
         try {
            if (psInformacion != null) psInformacion.close();
            if (psUsuario != null) psUsuario.close();
            if (conn != null) {
               conn.setAutoCommit(true);
               conn.close();
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

   @Override
   public int Elimnar(Cliente entity, String dato) {
      String documento = JOptionPane.showInputDialog("Ingrese el documento del cliente a eliminar:");
      if (documento == null || documento.trim().isEmpty()) return 0;

      int confirmacion = JOptionPane.showConfirmDialog(null,
         "⚠️ ¿Está seguro de eliminar el cliente con documento " + documento + "?\n\n" +
         "Esta acción eliminará:\n" +
         "- Usuario\n" +
         "- Información personal\n" +
         "- Relación con roles\n\n" +
         "Esta acción no se puede deshacer.",
         "Confirmar Eliminación",
         JOptionPane.YES_NO_OPTION,
         JOptionPane.WARNING_MESSAGE);

      if (confirmacion != JOptionPane.YES_OPTION) {
         return 0;
      }

      Connection conn = null;

      try {
         conn = ConexionDB.conectar();
         conn.setAutoCommit(false);

         // Buscar usuario_id
         String sqlBuscar = "SELECT u.usuario_id FROM usuario u " +
                           "INNER JOIN informacion i ON u.usuario_id = i.usuario_id_fk " +
                           "WHERE i.documento = ?";
         PreparedStatement psBuscar = conn.prepareStatement(sqlBuscar);
         psBuscar.setString(1, documento);
         ResultSet rs = psBuscar.executeQuery();

         if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            return 0;
         }

         int usuarioId = rs.getInt("usuario_id");
         rs.close();
         psBuscar.close();

         // Eliminar en orden por foreign keys
         // 1. usuario_rol
         String sqlRol = "DELETE FROM usuario_rol WHERE usuario_id_fk = ?";
         PreparedStatement psRol = conn.prepareStatement(sqlRol);
         psRol.setInt(1, usuarioId);
         psRol.executeUpdate();
         psRol.close();

         // 2. informacion
         String sqlInfo = "DELETE FROM informacion WHERE usuario_id_fk = ?";
         PreparedStatement psInfo = conn.prepareStatement(sqlInfo);
         psInfo.setInt(1, usuarioId);
         psInfo.executeUpdate();
         psInfo.close();

         // 3. usuario
         String sqlUsuario = "DELETE FROM usuario WHERE usuario_id = ?";
         PreparedStatement psUsuario = conn.prepareStatement(sqlUsuario);
         psUsuario.setInt(1, usuarioId);
         int resultado = psUsuario.executeUpdate();
         psUsuario.close();

         conn.commit();

         if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "✅ Cliente eliminado exitosamente.");
         }

         return resultado;

      } catch (SQLException e) {
         if (conn != null) {
            try {
               conn.rollback();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
         }
         JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
         e.printStackTrace();
         return 0;

      } finally {
         try {
            if (conn != null) {
               conn.setAutoCommit(true);
               conn.close();
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}