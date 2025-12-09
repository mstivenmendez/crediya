package proyecto.personal;

import java.time.LocalDate;

public class Persona {

   private String nombre,apellido,correo,telefono, documento ;
   private LocalDate fechaNacimiento;

   public Persona(String nombre, String apellido, String correo, String telefono, String documento,
         LocalDate fechaNacimiento) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.correo = correo;
      this.telefono = telefono;
      this.documento = documento;
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
   public String getDocumento() {
      return documento;
   }
   public void setDocumento(String cedula) {
      this.documento = cedula;
   }
   public LocalDate getFechaNacimiento() {
      return fechaNacimiento;
   }
   public void setFechaNacimiento(LocalDate fechaNacimiento) {
      this.fechaNacimiento = fechaNacimiento;
   }
}
