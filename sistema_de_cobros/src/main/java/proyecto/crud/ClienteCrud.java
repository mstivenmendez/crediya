package proyecto.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import proyecto.conector.ConexionDB;
import proyecto.personal.Cliente;

public class ClienteCrud implements CrudEntity<Cliente> {

   private ConexionDB db;

   public ClienteCrud() {
      db = new ConexionDB();
   }

   @Override
   public int Guardar(Cliente entity) {
      String sql = "INSERT INTO persona(nombre, apellido) VALUES (?, ?)";

      try (Connection con = ConexionDB.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

         ps.setString(1, entity.getNombre());
         ps.setString(2, entity.getApellido());

         return ps.executeUpdate(); // 1 si se insertó correctamente

      } catch (Exception e) {
         e.printStackTrace();
         return 0;
      }
   }

   @Override
   public int Elimnar(Cliente entity) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'elimnar'");
   }

   @Override
   public int Actualizar(Cliente entity, int id) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
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

}
