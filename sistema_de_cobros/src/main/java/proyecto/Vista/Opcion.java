package proyecto.Vista;

import javax.swing.JOptionPane;

import proyecto.Validaciones.ValidarNumero;

public class Opcion {
   Menu ingreso = new Menu();
   ValidarNumero numero = new ValidarNumero();

   public void VistaSesionOpcion(int valor){
      switch (valor) {
            case 1:
               VistaInicioOpcion(numero.solicitarEntero(ingreso.VistaInicio(),2));
               break;
            case 2:
               JOptionPane.showMessageDialog(null, "Registro");
               break;
            case 0:
               JOptionPane.showMessageDialog(null, "Saliendo del Programa...");
               break;
         }
   }

   public void VistaInicioOpcion(int valor){
      switch (valor) {
            case 1:
               VistaUsuarioOpcion(numero.solicitarEntero(ingreso.VistaUsuario(),7));
               break;
            case 2:
               VistaAdministradorOpcion(numero.solicitarEntero(ingreso.VistaAdministrador(),5));
               break;
            case 0:
               JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
               break;
         }
   }

   public void VistaAdministradorOpcion(int valor){
      switch (valor) {
            case 1:
               VistaAdministradorEmpledaoOpcion(numero.solicitarEntero(ingreso.VistaEmpleado(), 4));
               break;
            case 2:
               VistaGestionClientesOpcion(numero.solicitarEntero(ingreso.VistaGestionClientes(), 3));
               break;
            case 3:
               VistaGestionPrestamosOpcion(numero.solicitarEntero(ingreso.VistaGestionPrestamos(), 3));
               break;
            case 4:
               VistaGestionPagosOpcion(numero.solicitarEntero(ingreso.VistaGestionPagos(), 3));
               break;
            case 5:
               VistaGestionReportesOpcion(numero.solicitarEntero(ingreso.VistaGestionReportes(), 5));
               return;
            case 0:
               JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
               break;
         }
   }

   public void VistaAdministradorEmpledaoOpcion(int valor){
      switch (valor) {
            case 1:
               JOptionPane.showMessageDialog(null, "ingreso 1");
               break;
            case 2:
               JOptionPane.showMessageDialog(null, "ingreso2");
               break;
            case 3:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 4:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 0:
               JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
               valor = -1;
               break;
         }
   }

   public void VistaGestionClientesOpcion(int valor){
      switch (valor) {
            case 1:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 2:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 3:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 0:
               JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
         }
   }

   public void VistaGestionPrestamosOpcion(int valor){
      switch (valor) {
            case 1:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 2:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 3:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 0:
               JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
               break;
         }
   }

   public void VistaGestionPagosOpcion(int valor){
      switch (valor) {
            case 1:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 2:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 3:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 0:
               JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
               break;
         }
   }

   public void VistaGestionReportesOpcion(int valor){
      switch (valor) {
            case 1:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 2:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 3:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 4:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 5:
               JOptionPane.showMessageDialog(null, "ingreso");
               return;
            case 0:
               JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
               break;
         }
   }

   public void VistaUsuarioOpcion(int valor){
      switch (valor) {
            case 1:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 2:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 3:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 4:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 5:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 6:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 7:
               JOptionPane.showMessageDialog(null, "ingreso");
               break;
            case 0:
               JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
               break;
         }
   }




}
