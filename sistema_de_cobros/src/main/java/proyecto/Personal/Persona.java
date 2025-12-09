package proyecto.Personal;

import java.time.LocalDate;

public class Persona {

   private String nombre,apellido,correo,telefono, cedula ;
   private LocalDate fechaNacimiento;

   public Persona(String nombre, String apellido, String correo, String telefono, String cedula,
         LocalDate fechaNacimiento) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.correo = correo;
      this.telefono = telefono;
      this.cedula = cedula;
      this.fechaNacimiento = fechaNacimiento;
   }

   public Persona() {
   }

   public String getNombre() {
      return nombre;
   }
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }
   public String getApellido() {
      return apellido;
   }
   public void setApellido(String apellido) {
      this.apellido = apellido;
   }
   public String getCorreo() {
      return correo;
   }
   public void setCorreo(String correo) {
      this.correo = correo;
   }
   public String getTelefono() {
      return telefono;
   }
   public void setTelefono(String telefono) {
      this.telefono = telefono;
   }
   public String getCedula() {
      return cedula;
   }
   public void setCedula(String cedula) {
      this.cedula = cedula;
   }
   public LocalDate getFechaNacimiento() {
      return fechaNacimiento;
   }
   public void setFechaNacimiento(LocalDate fechaNacimiento) {
      this.fechaNacimiento = fechaNacimiento;
   }
}
