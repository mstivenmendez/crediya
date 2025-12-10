package proyecto.crud;

import java.util.List;

import proyecto.personal.Empleado;

public class EmpleadoCrud implements CrudEntity<Empleado>{

   @Override
   public int Guardar(Empleado entity) {
      return 1;
   }

   @Override
   public int Elimnar(Empleado entity) {
      return 1;
   }

   @Override
   public int Actualizar(Empleado entity, int id) {
      return 1;
   }

   @Override
   public int BuscarPor(Object[] args) {
      return 1;
   }

   @Override
   public List<Empleado> Buscar() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'buscar'");
   }

}
