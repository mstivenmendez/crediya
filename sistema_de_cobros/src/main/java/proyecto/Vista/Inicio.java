package proyecto.vista;

import javax.swing.JOptionPane;

import proyecto.validaciones.ValidarNumero;

public class Inicio {
   ValidarNumero ingreso = new ValidarNumero();
   Opcion valor = new Opcion();
   Menu vista = new Menu();

   public boolean bandera = true;

   public void Iniciar(){

      do {
         
         String opcion = vista.VistaSesion();
         int numero = ingreso.solicitarEntero(opcion,2);
         if(numero == 0){
            JOptionPane.showMessageDialog(null, "GRACIAS POR UTILIZAR NUESTRO PROGRAMA");
            bandera = false;
         }
         valor.VistaSesionOpcion(numero);

      } while (bandera);
   }
}
