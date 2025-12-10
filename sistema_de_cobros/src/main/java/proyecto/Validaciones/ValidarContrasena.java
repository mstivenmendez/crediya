package proyecto.validaciones;

import javax.swing.JOptionPane;

public class ValidarContrasena {

   public String ValidarClave(String valor) {

         if (valor == null) {
         return null;
      }

      // Validación única con regex completo
      if (!valor.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$")) {
         JOptionPane.showMessageDialog(null,
            "No cumple con los requistos \n");
         return null;
      }

      return valor;
   }
}
