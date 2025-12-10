package proyecto.crud;


import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import proyecto.personal.Cliente;
import proyecto.solicitud.Datos;
import proyecto.util.IngresoDatos;

public class ClienteCrud implements CrudEntity<Cliente> {

   Datos insertar = new Datos();
   IngresoDatos conexion = new IngresoDatos();

   @Override
   public int Guardar(Cliente entity, String sql) {

      int resultado = conexion.ejecutar(sql, ps -> {
         try {
            entity.setNombre(insertar.Nombre());
            entity.setNombre2(insertar.Nombre2());
            entity.setApellido(insertar.Apellido());
            entity.setApellido2(insertar.Apellido2());
            entity.setCorreo(insertar.Correo());
            entity.setDocumento(insertar.Telefono());
            ps.setString(1, entity.getNombre());
         } catch (SQLException e) {
            throw new RuntimeException(e);
         }
      });
      if (resultado > 0) {
         JOptionPane.showMessageDialog(null, " Guardo Usuario Correctamente");
      }
      return resultado;
   }

   @Override
   public int BuscarPor(Object[] args) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'buscarPor'");
   }

   @Override
   public List<Cliente> Buscar() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'buscar'");
   }

   @Override
   public int Elimnar(Cliente entity, String dato) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'Elimnar'");
   }

   @Override
   public int Actualizar(Cliente entity, int id, String dato) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'Actualizar'");
   }
}
