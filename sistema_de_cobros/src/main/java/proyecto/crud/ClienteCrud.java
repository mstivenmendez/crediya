package proyecto.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import proyecto.conector.ConexionDB;
import proyecto.personal.Cliente;
import proyecto.solicitud.Datos;
import proyecto.util.IngresoDatos;

public class ClienteCrud implements CrudEntity<Cliente> {

   private ConexionDB db;
   Datos insertar = new Datos();
   IngresoDatos conexion = new IngresoDatos();

   public ClienteCrud() {
      db = new ConexionDB();
   }

   @Override
   public int Guardar(Cliente entity, String sql) {

      return conexion.ejecutar(sql, ps ->{
         try {
            entity.setNombre(insertar.Nombre());
            entity.setNombre2(insertar.Nombre2());
            entity.setApellido(insertar.Apellido());
            entity.setApellido2(insertar.Apellido2());
            entity.setCorreo(insertar.Correo());
            entity.setDocumento(insertar.Telefono());
         } catch (Exception e) {

         }
      });

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
