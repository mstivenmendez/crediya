package proyecto.validaciones;

import javax.swing.JOptionPane;

public class ValidarUsuario {

   public String ValidarUsuarioU(String valor){
      if (valor == null) {
         return null;
      }

      // Validación 1: ¿Está vacío?
      if (valor.trim().isEmpty()) {
         JOptionPane.showMessageDialog(null, "El valor no puede estar vacío");
         return null;
      }

      // Validación 2: Solo letras y números, sin espacios ni caracteres especiales
      if (!valor.matches("^[a-zA-Z0-9]+$")) {
         JOptionPane.showMessageDialog(null,
            "Solo se permiten letras y números\n");
            return null;
         }
      return valor;
   }
}
