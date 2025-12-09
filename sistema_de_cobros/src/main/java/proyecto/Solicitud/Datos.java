package proyecto.Solicitud;

import javax.swing.JOptionPane;

public class Datos {

   public String Nombre() {
      String nombre = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n" +
         "Ingrese el nombre \n");
      return nombre;
   }

   public String Usuario() {
      String usuario = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n" +
         "Ingrese el usuario \n");
      return usuario;
   }

   public String Apellido() {
      String apellido = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n" +
         "Ingrese el apellido \n");
      return apellido;
   }

   public String Password() {
      String password = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n" +
         "Ingrese la contraseña");
      return password;
   }

   public String Cedula() {
      String cedula = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n" +
         "Ingrese la cedula");
      return cedula;
   }

   public String Correo() {
      String correo = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n" +
         "Ingrese el correo ");
      return correo;
   }

   public String Telefono() {
      String telefono = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n" +
         "Ingrese el telefono ");
      return telefono;
   }

   public String IdPrestamo() {
      String prestamo = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n" +
         "Ingrese el valor del prestamo ");
      return prestamo;
   }

   public String valorPrestamo() {
      String valorPrestamo = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n" +
         "Ingrese el valor del prestamo");
      return valorPrestamo;
   }

   public String valorInteres() {
      String valorIntere = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n" +
         "Ingrese los intereses del prestamo ");
      return valorIntere;
   }
}
