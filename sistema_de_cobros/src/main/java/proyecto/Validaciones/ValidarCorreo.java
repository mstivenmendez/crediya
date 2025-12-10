package proyecto.validaciones;

import javax.swing.JOptionPane;

public class ValidarCorreo {

   public String ValidarEmail(String valor){

      if (valor == null) {
         return null;
      }

      if (!valor.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
         JOptionPane.showMessageDialog(null,
            "Formato de correo inválido\n");
         return null;
      }
      return valor;
   }
}
