package proyecto.validaciones;

import javax.swing.JOptionPane;

public class ValidarString {

   public String ValidarTexto(String valor) {

         if (valor == null || valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ingrese un valor que no tenga espacios o que no esta vacio");
            return null;
         }

         if (!valor.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor coherente");
            return null;
         }

         if (valor.trim().length() < 2) {
            JOptionPane.showMessageDialog(null, "El rango de palabras es muy corta");
            return null;
         }
         return valor;
   }
}
