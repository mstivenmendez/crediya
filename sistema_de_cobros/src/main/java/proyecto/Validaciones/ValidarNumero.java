package proyecto.validaciones;

import javax.swing.JOptionPane;

public class ValidarNumero {

   public Integer solicitarEntero(String ingreso, int valor) {
      boolean bandera = true;
      do {

         ingreso = ingreso.trim();
         try {
            int numero = Integer.parseInt(ingreso);
            if (numero > valor || numero < 0) {
               JOptionPane.showMessageDialog(null, "Número fuera del rango.");
               return 0;
            }
            return numero;
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número entero.");
            return -1;
         }
      } while (bandera);
   }

   public Double solicitarDouble(String ingreso, double valor) {
      boolean bandera = true;
      do {
         if (ingreso == null) {
            JOptionPane.showMessageDialog(null, "Ingrese una opcion");
            return -1.0;
         }

         ingreso = ingreso.trim();

         try {
            double numero = Double.parseDouble(ingreso);

            if (numero > valor || numero < 0) {
               JOptionPane.showMessageDialog(null, "Número fuera del rango.");
               return -1.0;
            }

            return numero;

         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número.");
            return -1.0;
         }
      } while (bandera);
   }
}
