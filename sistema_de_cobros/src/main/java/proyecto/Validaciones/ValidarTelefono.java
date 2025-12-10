package proyecto.validaciones;

import javax.swing.JOptionPane;

public class ValidarTelefono {

   public String ValidarTelefonoU (String valor){
      if (valor == null) {
         return null;
      }

      if (!valor.matches("^[0-9]{10}$")) {
         JOptionPane.showMessageDialog(null,
            "El teléfono Incorrecto\n");
            return null;
      }
      return valor;
   }
}
