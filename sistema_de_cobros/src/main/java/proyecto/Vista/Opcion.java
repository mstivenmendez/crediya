package proyecto.vista;

import javax.swing.JOptionPane;
import proyecto.validaciones.ValidarNumero;
import proyecto.crud.ClienteCrud;
import proyecto.crud.EmpleadoCrud;
import proyecto.personal.Cliente;
import java.util.List;

public class Opcion {
   Menu ingreso = new Menu();
   ValidarNumero numero = new ValidarNumero();
   
   // Instancias de los CRUDs
   ClienteCrud clienteCrud = new ClienteCrud();
   EmpleadoCrud empleadoCrud = new EmpleadoCrud();

   public void VistaSesionOpcion(int valor){
      switch (valor) {
         case 1:
            VistaInicioOpcion(numero.solicitarEntero(ingreso.VistaInicio(),2));
            break;
         case 2:
            // Registro de nuevo cliente
            registrarNuevoCliente();
            break;
         case 0:
            JOptionPane.showMessageDialog(null, "Saliendo del Programa...");
            break;
      }
   }

   public void VistaInicioOpcion(Integer valor){
      if(valor == null) return;

      switch (valor) {
         case 1:
            VistaUsuarioOpcion(numero.solicitarEntero(ingreso.VistaUsuario(),7));
            break;
         case 2:
            // Bucle para mantener en el menú de administrador
            boolean continuarAdmin = true;
            while(continuarAdmin) {
               Integer opcionAdmin = numero.solicitarEntero(ingreso.VistaAdministrador(),5);
               if(opcionAdmin == null) continue;
               if(opcionAdmin == 0) {
                  JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
                  continuarAdmin = false;
               } else {
                  VistaAdministradorOpcion(opcionAdmin);
               }
            }
            break;
         case 0:
            JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
            break;
      }
   }

   public void VistaAdministradorOpcion(int valor){
      switch (valor) {
         case 1:
            // Gestión de empleados
            boolean continuarEmpleado = true;
            while(continuarEmpleado) {
               Integer opcion = numero.solicitarEntero(ingreso.VistaEmpleado(), 4);
               if(opcion == null) continue;
               if(opcion == 0) {
                  JOptionPane.showMessageDialog(null, "Regresando al menú de administrador...");
                  continuarEmpleado = false;
               } else {
                  VistaAdministradorEmpleadoOpcion(opcion);
               }
            }
            break;
         case 2:
            // Gestión de clientes
            boolean continuarClientes = true;
            while(continuarClientes) {
               Integer opcion = numero.solicitarEntero(ingreso.VistaGestionClientes(), 6);
               if(opcion == null) continue;
               if(opcion == 0) {
                  JOptionPane.showMessageDialog(null, "Regresando al menú de administrador...");
                  continuarClientes = false;
               } else {
                  VistaGestionClientesOpcion(opcion);
               }
            }
            break;
         case 3:
            // Gestión de préstamos
            boolean continuarPrestamos = true;
            while(continuarPrestamos) {
               Integer opcion = numero.solicitarEntero(ingreso.VistaGestionPrestamos(), 3);
               if(opcion == null) continue;
               if(opcion == 0) {
                  JOptionPane.showMessageDialog(null, "Regresando al menú de administrador...");
                  continuarPrestamos = false;
               } else {
                  VistaGestionPrestamosOpcion(opcion);
               }
            }
            break;
         case 4:
            // Gestión de pagos
            boolean continuarPagos = true;
            while(continuarPagos) {
               Integer opcion = numero.solicitarEntero(ingreso.VistaGestionPagos(), 3);
               if(opcion == null) continue;
               if(opcion == 0) {
                  JOptionPane.showMessageDialog(null, "Regresando al menú de administrador...");
                  continuarPagos = false;
               } else {
                  VistaGestionPagosOpcion(opcion);
               }
            }
            break;
         case 5:
            // Gestión de reportes
            boolean continuarReportes = true;
            while(continuarReportes) {
               Integer opcion = numero.solicitarEntero(ingreso.VistaGestionReportes(), 5);
               if(opcion == null) continue;
               if(opcion == 0) {
                  JOptionPane.showMessageDialog(null, "Regresando al menú de administrador...");
                  continuarReportes = false;
               } else {
                  VistaGestionReportesOpcion(opcion);
               }
            }
            break;
      }
   }

   public void VistaAdministradorEmpleadoOpcion(int valor){
      switch (valor) {
         case 1:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Registrar empleado");
            // Aquí irá empleadoCrud.Guardar() cuando esté implementado
            break;
         case 2:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Consultar empleados");
            // Aquí irá empleadoCrud.Buscar()
            break;
         case 3:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Actualizar empleado");
            // Aquí irá empleadoCrud.Actualizar()
            break;
         case 4:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Eliminar empleado");
            // Aquí irá empleadoCrud.Eliminar()
            break;
      }
   }

   public void VistaGestionClientesOpcion(int valor){
      switch (valor) {
         case 1:
            // ✅ REGISTRAR CLIENTE
            registrarCliente();
            break;
         case 2:
            // ✅ LISTAR CLIENTES
            listarClientes();
            break;
         case 3:
            // ✅ BUSCAR CLIENTE POR DOCUMENTO
            buscarClientePorDocumento();
            break;
         case 4:
            // ✅ ACTUALIZAR CLIENTE
            actualizarCliente();
            break;
         case 5:
            // ✅ CAMBIAR ESTADO DE CLIENTE
            cambiarEstadoCliente();
            break;
         case 6:
            // Consultar préstamos del cliente
            consultarPrestamosCliente();
            break;
      }
   }

   public void VistaGestionPrestamosOpcion(int valor){
      switch (valor) {
         case 1:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Crear préstamo");
            break;
         case 2:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Listar préstamos");
            break;
         case 3:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Cambiar estado del préstamo");
            break;
      }
   }

   public void VistaGestionPagosOpcion(int valor){
      switch (valor) {
         case 1:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Registrar pago");
            break;
         case 2:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Consultar historial de pagos");
            break;
         case 3:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Ver saldo pendiente");
            break;
      }
   }

   public void VistaGestionReportesOpcion(int valor){
      switch (valor) {
         case 1:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Préstamos activos");
            break;
         case 2:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Préstamos vencidos");
            break;
         case 3:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Clientes morosos");
            break;
         case 4:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Generar reporte automático");
            break;
         case 5:
            JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Historial completo de préstamos");
            break;
      }
   }

   public void VistaUsuarioOpcion(Integer valor){
      if(valor == null) return;

      boolean continuarUsuario = true;
      while(continuarUsuario) {
         if(valor == 0) {
            JOptionPane.showMessageDialog(null, "Regresando al menú principal...");
            continuarUsuario = false;
         } else {
            switch (valor) {
               case 1:
                  JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Ver mis datos personales");
                  break;
               case 2:
                  JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Consultar mis préstamos");
                  break;
               case 3:
                  JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Ver mis pagos");
                  break;
               case 4:
                  JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Realizar un pago");
                  break;
               case 5:
                  JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Realizar Solicitud De Préstamo");
                  break;
               case 6:
                  JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Simulación Préstamo");
                  break;
               case 7:
                  JOptionPane.showMessageDialog(null, "🚧 Función en desarrollo: Reportes (notificaciones)");
                  break;
            }
            valor = numero.solicitarEntero(ingreso.VistaUsuario(), 7);
            if(valor == null) continue;
         }
      }
   }

   // ==================== MÉTODOS DEL CRUD DE CLIENTES ====================

   /**
    * Registrar un nuevo cliente desde el menú principal (opción 2 de sesión)
    */
   private void registrarNuevoCliente() {
      JOptionPane.showMessageDialog(null,
         "╔═══════════════════════════════════╗\n" +
         "║    REGISTRO DE NUEVO CLIENTE      ║\n" +
         "╚═══════════════════════════════════╝\n\n" +
         "📝 Complete el formulario de registro\n" +
         "Todos los campos son obligatorios.",
         "Registro",
         JOptionPane.INFORMATION_MESSAGE);

      Cliente nuevoCliente = new Cliente();
      int resultado = clienteCrud.Guardar(nuevoCliente, null);

      if (resultado > 0) {
         JOptionPane.showMessageDialog(null,
            "✅ ¡Registro exitoso!\n\n" +
            "Ya puede iniciar sesión con sus credenciales.",
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE);
      }
   }

   /**
    * Registrar cliente desde el menú de administrador
    */
   private void registrarCliente() {
      JOptionPane.showMessageDialog(null,
         "╔═══════════════════════════════════╗\n" +
         "║   REGISTRAR CLIENTE (ADMIN)       ║\n" +
         "╚═══════════════════════════════════╝\n\n" +
         "📋 A continuación ingrese los datos del cliente.",
         "Registro Administrativo",
         JOptionPane.INFORMATION_MESSAGE);

      Cliente nuevoCliente = new Cliente();
      int resultado = clienteCrud.Guardar(nuevoCliente, null);

      if (resultado > 0) {
         JOptionPane.showMessageDialog(null,
            "✅ Cliente registrado exitosamente en el sistema",
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE);
      }
   }

   /**
    * Listar todos los clientes
    */
   private void listarClientes() {
      List<Cliente> clientes = clienteCrud.Buscar();

      if (clientes.isEmpty()) {
         JOptionPane.showMessageDialog(null,
            "ℹ️ No hay clientes registrados en el sistema.",
            "Sin Resultados",
            JOptionPane.INFORMATION_MESSAGE);
         return;
      }

      StringBuilder lista = new StringBuilder();
      lista.append("╔═══════════════════════════════════════════════╗\n");
      lista.append("║          LISTADO DE CLIENTES                  ║\n");
      lista.append("╚═══════════════════════════════════════════════╝\n\n");
      lista.append(String.format("📊 Total de clientes: %d\n\n", clientes.size()));

      for (int i = 0; i < clientes.size(); i++) {
         Cliente c = clientes.get(i);
         lista.append(String.format("───── Cliente #%d ─────\n", (i + 1)));
         lista.append(String.format("🆔 ID: %s\n", c.getIdCliente()));
         lista.append(String.format("👤 Nombre: %s %s %s %s\n", 
            c.getNombre(), 
            c.getNombre2() != null ? c.getNombre2() : "",
            c.getApellido(),
            c.getApellido2() != null ? c.getApellido2() : ""));
         lista.append(String.format("📧 Correo: %s\n", c.getCorreo()));
         lista.append(String.format("📄 Documento: %s\n", c.getDocumento()));
         lista.append(String.format("📱 Teléfono: %s\n", c.getTelefono()));
         lista.append(String.format("👥 Usuario: %s\n", c.getUsuario()));
         lista.append(String.format("📊 Estado: %s\n", c.getEstado()));
         lista.append("\n");
      }

      // Mostrar con scroll si es muy largo
      JOptionPane.showMessageDialog(null,
         lista.toString(),
         "Listado de Clientes",
         JOptionPane.INFORMATION_MESSAGE);
   }

   /**
    * Buscar cliente por documento
    */
   private void buscarClientePorDocumento() {
      JOptionPane.showMessageDialog(null,
         "╔═══════════════════════════════════╗\n" +
         "║     BUSCAR CLIENTE                ║\n" +
         "╚═══════════════════════════════════╝\n\n" +
         "🔍 Búsqueda por número de documento",
         "Búsqueda",
         JOptionPane.INFORMATION_MESSAGE);

      clienteCrud.BuscarPor(new Object[]{});
   }

   /**
    * Actualizar datos de un cliente
    */
   private void actualizarCliente() {
      JOptionPane.showMessageDialog(null,
         "╔═══════════════════════════════════╗\n" +
         "║   ACTUALIZAR DATOS CLIENTE        ║\n" +
         "╚═══════════════════════════════════╝\n\n" +
         "✏️ Actualización de información del cliente",
         "Actualización",
         JOptionPane.INFORMATION_MESSAGE);

      Cliente cliente = new Cliente();
      clienteCrud.Actualizar(cliente, 0, null);
   }

   /**
    * Cambiar estado de un cliente (ACTIVO, INACTIVO, SUSPENDIDO)
    */
   private void cambiarEstadoCliente() {
      JOptionPane.showMessageDialog(null,
         "╔═══════════════════════════════════╗\n" +
         "║   CAMBIAR ESTADO CLIENTE          ║\n" +
         "╚═══════════════════════════════════╝\n\n" +
         "🔄 Cambio de estado del cliente\n" +
         "Estados disponibles: ACTIVO, INACTIVO, SUSPENDIDO",
         "Cambio de Estado",
         JOptionPane.INFORMATION_MESSAGE);

      // Reutilizar el método de actualizar que ya tiene cambio de estado
      Cliente cliente = new Cliente();
      clienteCrud.Actualizar(cliente, 0, null);
   }

   /**
    * Consultar préstamos de un cliente específico
    */
   private void consultarPrestamosCliente() {
      String documento = JOptionPane.showInputDialog(
         "╔═══════════════════════════════════╗\n" +
         "║   CONSULTAR PRÉSTAMOS             ║\n" +
         "╚═══════════════════════════════════╝\n\n" +
         "Ingrese el documento del cliente:");

      if (documento == null || documento.trim().isEmpty()) {
         return;
      }

      // Primero buscar el cliente
      int clienteEncontrado = clienteCrud.BuscarPor(new Object[]{documento});

      if (clienteEncontrado > 0) {
         // Aquí iría la consulta de préstamos cuando esté implementada
         JOptionPane.showMessageDialog(null,
            "🚧 Función en desarrollo:\n\n" +
            "Consulta de préstamos del cliente con documento: " + documento,
            "En Desarrollo",
            JOptionPane.INFORMATION_MESSAGE);
      }
   }
}