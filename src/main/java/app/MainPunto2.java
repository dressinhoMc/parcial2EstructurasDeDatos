package app;

import model.HistorialAcciones;
import model.Accion;
import model.Stack;
import model.Input;

public class MainPunto2 {

    public static void main(String[] args) {
        HistorialAcciones historial = new HistorialAcciones();
        precargarAcciones(historial);
        int opcion = 0;
        do {
            System.out.println("\n===== MENÚ HISTORIAL DE ACCIONES =====");
            System.out.println("1. Añadir nueva acción");
            System.out.println("2. Sacar (pop) última acción");
            System.out.println("3. Obtener segmento de acciones (por posiciones)");
            System.out.println("4. Salir");

            opcion = Input.ingresarEntero("Elige una opción: ");

            switch (opcion) {
                case 1:
                    String id = Input.ingresarTexto("Ingrese el ID de la acción (ej. A16): ");
                    String descripcion = Input.ingresarTexto("Ingrese la descripción de la acción: ");
                    Accion nuevaAccion = new Accion(id, descripcion);
                    historial.addAccion(nuevaAccion);
                    break;

                case 2:
                    try {
                        historial.popAccion();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\n--- OBTENER SEGMENTO ---");
                    int inicio = Input.ingresarEntero("Ingrese la posición de inicio (desde el tope, 1 en adelante): ");
                    int fin = Input.ingresarEntero("Ingrese la posición de fin: ");
                    try {
                        Stack<Accion> segmento = historial.obtenerSegmento(inicio, fin);
                        System.out.println("\n--- RESULTADO: SEGMENTO DE LA POSICIÓN " + inicio + " A " + fin + " ---");
                        if (segmento.isEmpty()) {
                            System.out.println("Segmento vacío (verifique que los rangos sean válidos y la pila no esté vacía).");
                        } else {
                            imprimirPilaResultado(segmento);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al procesar el segmento: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("¡Saliendo del sistema de acciones!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 4);
    }

    // Método con las 15 acciones quemadas explícitamente (A1 a A15)
    private static void precargarAcciones(HistorialAcciones historial) {
        historial.addAccion(new Accion("A1", "Abrir archivo"));
        historial.addAccion(new Accion("A2", "Escribir titulo"));
        historial.addAccion(new Accion("A3", "Borrar caracter"));
        historial.addAccion(new Accion("A4", "Cambiar fuente a Negrita"));
        historial.addAccion(new Accion("A5", "Escribir párrafo 1"));
        historial.addAccion(new Accion("A6", "Insertar imagen"));
        historial.addAccion(new Accion("A7", "Deshacer insertar imagen"));
        historial.addAccion(new Accion("A8", "Copiar texto"));
        historial.addAccion(new Accion("A9", "Pegar texto"));
        historial.addAccion(new Accion("A10", "Alinear al centro"));
        historial.addAccion(new Accion("A11", "Subrayar subtítulo"));
        historial.addAccion(new Accion("A12", "Escribir párrafo 2"));
        historial.addAccion(new Accion("A13", "Guardar cambios borrador"));
        historial.addAccion(new Accion("A14", "Cambiar color de texto"));
        historial.addAccion(new Accion("A15", "Cerrar sesión de edición"));

        System.out.println("\n> ¡Se han cargado las 15 acciones (A1 a A15) al historial con éxito!\n");
    }

    // Método auxiliar para mostrar el contenido de la pila resultante sin alterarla
    private static void imprimirPilaResultado(Stack<Accion> pila) {
        Stack<Accion> aux = new Stack<>();
        while (!pila.isEmpty()) {
            Accion acc = pila.pop();
            System.out.println(acc);
            aux.push(acc);
        }
        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }
}
