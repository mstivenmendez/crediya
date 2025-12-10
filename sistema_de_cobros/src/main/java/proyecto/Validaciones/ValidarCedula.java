package proyecto.validaciones;

import javax.swing.JOptionPane;

public class ValidarCedula {

   public String ValidarDocumento(String valor){
      if (valor == null) {
         return null;
      }

      if (!valor.matches("^[0-9]{7,11}$")) {
         JOptionPane.showMessageDialog(null,
            "Debe contener solo números\n");
            return null;
      }

      // ✅ Número válido
      return valor;
   }
}
