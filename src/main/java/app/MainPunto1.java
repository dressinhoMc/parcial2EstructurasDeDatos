package app;

import model.HistorialOperaciones;
import model.Operacion;
import model.Stack;
import model.Input;

public class MainPunto1 {

    public static void main(String[] args) {
        HistorialOperaciones historial = new HistorialOperaciones();

        // 1. Precargamos las 20 operaciones quemadas (mix de confirmadas true y anuladas false)
        precargarOperaciones(historial);

        int opcion = 0;
        do {
            System.out.println("\n===== MENÚ HISTORIAL DE OPERACIONES =====");
            System.out.println("1. Añadir nueva operación");
            System.out.println("2. Sacar (pop) última operación");
            System.out.println("3. Obtener últimas n operaciones confirmadas");
            System.out.println("4. Salir");

            opcion = Input.ingresarEntero("Elige una opción: ");

            switch (opcion) {
                case 1:
                    String codigo = Input.ingresarTexto("Ingrese el código de la operación: ");
                    boolean estado = Input.ingresarBoolean("¿Está confirmada?");
                    Operacion nuevaOp = new Operacion(codigo, estado); // Asegúrate de que tu constructor reciba estos parámetros
                    historial.addOperacion(nuevaOp);
                    break;

                case 2:
                    try {
                        historial.popOperacion();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    int n = Input.ingresarEntero("Ingrese la cantidad (n) de operaciones confirmadas a buscar: ");
                    try {
                        Stack<Operacion> ultimas = historial.obtenerUltimasConfirmadas(n);
                        System.out.println("\n--- RESULTADO: ÚLTIMAS " + n + " CONFIRMADAS ---");
                        if (ultimas.isEmpty()) {
                            System.out.println("No hay operaciones confirmadas o la pila está vacía.");
                        } else {
                            // Recorremos o imprimimos la pila resultante
                            imprimirPilaResultado(ultimas);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al procesar: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("¡Saliendo del sistema de historial. Éxitos con la sustentación!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 4);
    }

    private static void precargarOperaciones(HistorialOperaciones historial) {
        historial.addOperacion(new Operacion("O1", true));
        historial.addOperacion(new Operacion("O2", false));
        historial.addOperacion(new Operacion("O3", true));
        historial.addOperacion(new Operacion("O4", true));
        historial.addOperacion(new Operacion("O5", false));
        historial.addOperacion(new Operacion("O6", true));
        historial.addOperacion(new Operacion("O7", false));
        historial.addOperacion(new Operacion("O8", true));
        historial.addOperacion(new Operacion("O9", true));
        historial.addOperacion(new Operacion("O10", false));
        historial.addOperacion(new Operacion("O11", true));
        historial.addOperacion(new Operacion("O12", true));
        historial.addOperacion(new Operacion("O13", false));
        historial.addOperacion(new Operacion("O14", true));
        historial.addOperacion(new Operacion("O15", false));
        historial.addOperacion(new Operacion("O16", true));
        historial.addOperacion(new Operacion("O17", true));
        historial.addOperacion(new Operacion("O18", false));
        historial.addOperacion(new Operacion("O19", true));
        historial.addOperacion(new Operacion("O20", true));

        System.out.println("\n> ¡Se han cargado las 20 operaciones (O1 a O20) al historial con éxito!\n");
    }

    // Método auxiliar para mostrar el contenido de la pila resultante sin alterarla
    private static void imprimirPilaResultado(Stack<Operacion> pila) {
        Stack<Operacion> aux = new Stack<>();
        while (!pila.isEmpty()) {
            Operacion op = pila.pop();
            System.out.println(op.toString());
            aux.push(op);
        }
        while (!aux.isEmpty()) {
            pila.push(aux.pop());
        }
    }
}
