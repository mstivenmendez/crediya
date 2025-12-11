package proyecto.vista;

import javax.swing.JOptionPane;

public class Menu {

   // Vista inicial del proyecto
   public String VistaSesion(){
      String opcion = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n"
                  + "🔐 1. Iniciar Sesión \n"
                  + "📝👤 2. Registrarte\n"
                  + "🚪⬅️ 0. Salir\n");
      return opcion;
   }

   public String VistaInicio(){
      String opcion = JOptionPane.showInputDialog(null,
         " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n"
                  + "🔐 1. Iniciar Sesión Usuario\n"
                  + "🔐 2. Iniciar Sesión Administrador\n"
                  + "🚪⬅️ 0. Salir\n");
      return opcion;
   }

   // Vista de lo que va ver el administrador
   public String VistaAdministrador(){
      String ingreso = JOptionPane.showInputDialog(null,
            " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n"
            + " 🏦💰 Menú Administrador 💰🏦 \n"
                  + "1. Gestión de Empleados 🧑‍💼\n"
                  + "2. Gestión de Clientes 👥\n"
                  + "3. Gestión de Préstamos 💰\n"
                  + "4. Gestión de Pagos 💵\n"
                  + "5. Reportes 📊\n"
                  + "0. Cerrar Sesión 🔙\n");
      return ingreso;
   }

   public String VistaEmpleado(){
      String ingreso = JOptionPane.showInputDialog(null,
            " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n"
            + " 🏦💰 Gestión de Empleados 💰🏦 \n"
                  + "1. Registrar empleado ➕🧑‍💼\n"
                  + "2. Consultar empleados 📋\n"
                  + "3. Actualizar empleado ✏️\n"
                  + "4. Eliminar empleado ❌\n"
                  + "0. Volver 🔙\n");
      return ingreso;
   }

   public String VistaGestionClientes(){
      String ingreso = JOptionPane.showInputDialog(null,
            " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n"
            + " 🏦💰 Gestión de Clientes 💰🏦 \n"
                  + "1. Registrar cliente ➕👤\n"
                  + "2. Listar clientes 📋\n"
                  + "3. Buscar cliente por documento 🔍\n"
                  + "4. Actualizar cliente ✏️\n"
                  + "5. Cambiar estado de cliente 🔄\n"
                  + "6. Consultar préstamos del cliente 💰\n"
                  + "0. Volver 🔙\n");
      return ingreso;
   }

   public String VistaGestionPrestamos(){
      String ingreso = JOptionPane.showInputDialog(null,
            " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n"
            + " 🏦💰 Gestión de Préstamos 💰🏦 \n"
                  + "1. Crear préstamo ➕💰\n"
                  + "2. Listar préstamos 📋\n"
                  + "3. Cambiar estado del préstamo 🔄\n"
                  + "0. Volver 🔙\n");
      return ingreso;
   }

   public String VistaGestionPagos(){
      String ingreso = JOptionPane.showInputDialog(null,
            " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n"
            + " 🏦💰 Gestión de Pagos 💰🏦 \n"
                  + "1. Registrar pago 🧾💵\n"
                  + "2. Consultar historial de pagos 📜\n"
                  + "3. Ver saldo pendiente 🔍💸\n"
                  + "0. Volver 🔙\n");
      return ingreso;
   }

   public String VistaGestionReportes(){
      String ingreso = JOptionPane.showInputDialog(null,
            " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n"
            + " 🏦💰 Gestión de Reportes 💰🏦 \n"
                  + "1. Préstamos activos 🟢\n"
                  + "2. Préstamos vencidos 🔴\n"
                  + "3. Clientes morosos ⚠️\n"
                  + "4. Generar reporte automático (enviar notificaciones) 🔔 \n"
                  + "5. Historial completo de préstamos 📘\n"
                  + "0. Volver 🔙\n");
      return ingreso;
   }

   // Vista de lo que va ver el Usuario
   public String VistaUsuario(){
      String ingreso = JOptionPane.showInputDialog(null,
            " 🏦💰 SISTEMA DE COBROS DE CARTERA 💰🏦 \n"
            + " 🏦💰 Menú Usuario 💰🏦 \n"
                  + "1. Ver mis datos personales 👀\n"
                  + "2. Consultar mis préstamos 💰\n"
                  + "3. Ver mis pagos 💵📄\n"
                  + "4. Realizar un pago 🧾💳\n"
                  + "5. Realizar Solicitud De Préstamo 💵\n"
                  + "6. Simulación Préstamo 🔁🔄\n"
                  + "7. Reportes (notificaciones) 🔔 \n"
                  + "0. Cerrar Sesión 🔙\n");
      return ingreso;
   }
}