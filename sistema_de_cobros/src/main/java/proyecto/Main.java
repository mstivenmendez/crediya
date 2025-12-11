package proyecto;

import proyecto.vista.Inicio;

/**
 * Clase principal del Sistema de Cobros de Cartera
 * 
 * @author Tu Nombre
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        // Crear instancia de la clase Inicio que maneja el flujo del programa
        Inicio sistema = new Inicio();

        // Iniciar el sistema
        sistema.Iniciar();
    }
}