package proyecto.crud;

import java.util.List;

public interface CrudEntity<T> {

   public int Guardar(T entity);

   public int Elimnar(T entity);

   public int Actualizar(T entity, int id);

   public int BuscarPor(Object[] args);

   public List<T> Buscar();

}
