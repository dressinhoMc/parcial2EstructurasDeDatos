package app;

import model.CentroSoporte;
import model.Solicitud;
import model.Cola;
import model.Input;

public class MainPunto3{

    public static void main(String[] args) {
        CentroSoporte centro = new CentroSoporte();

        // 1. Precargamos las 10 solicitudes quemadas de forma explícita (S1 a S10)
        precargarSolicitudes(centro);

        int opcion = 0;
        do {
            System.out.println("\n===== MENÚ CENTRO DE SOPORTE =====");
            System.out.println("1. Añadir nueva solicitud");
            System.out.println("2. Atender (desencolar) primera solicitud pendiente");
            System.out.println("3. Seleccionar solicitudes por minutos disponibles");
            System.out.println("4. Salir");

            opcion = Input.ingresarEntero("Elige una opción: ");

            switch (opcion) {
                case 1:
                    String id = Input.ingresarTexto("Ingrese el ID de la solicitud (ej. S11): ");
                    boolean prioridad = Input.ingresarBoolean("¿Es de prioridad ALTA? (y para true / n para false): ");
                    int duracion = Input.ingresarEntero("Ingrese la duración estimada en minutos: ");
                    Solicitud nuevaSol = new Solicitud(id, prioridad, duracion);
                    centro.addSolicitud(nuevaSol);
                    break;

                case 2:
                    try {
                        centro.desencolarSolicitud();
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\n--- SELECCIÓN DE SOLICITUDES POR TIEMPO ---");
                    int minutos = Input.ingresarEntero("Ingrese los minutos disponibles: ");
                    try {
                        Cola<Solicitud> seleccionadas = centro.seleccionarSolicitudes(minutos);

                        System.out.println("\n>>> SOLICITUDES SELECCIONADAS:");
                        if (seleccionadas.isEmpty()) {
                            System.out.println("No se seleccionó ninguna solicitud.");
                        } else {
                            imprimirColaResultado(seleccionadas);
                        }
                    } catch (Exception e) {
                        System.out.println("Error al procesar: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("¡Saliendo del centro de soporte. Éxitos rotundos con tu sustentación!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 4);
    }

    // Método con las 10 solicitudes quemadas explícitamente (S1 a S10)
    // true = ALTA, false = NORMAL
    private static void precargarSolicitudes(CentroSoporte centro) {
        centro.addSolicitud(new Solicitud("S1", false, 15)); // Normal, 15 min
        centro.addSolicitud(new Solicitud("S2", true, 20));  // Alta, 20 min
        centro.addSolicitud(new Solicitud("S3", false, 10)); // Normal, 10 min
        centro.addSolicitud(new Solicitud("S4", true, 25));  // Alta, 25 min
        centro.addSolicitud(new Solicitud("S5", false, 5));  // Normal, 5 min
        centro.addSolicitud(new Solicitud("S6", true, 10));  // Alta, 10 min
        centro.addSolicitud(new Solicitud("S7", false, 30)); // Normal, 30 min
        centro.addSolicitud(new Solicitud("S8", true, 15));  // Alta, 15 min
        centro.addSolicitud(new Solicitud("S9", false, 20)); // Normal, 20 min
        centro.addSolicitud(new Solicitud("S10", true, 5)); // Alta, 5 min

        System.out.println("\n> ¡Se han cargado las 10 solicitudes (S1 a S10) al centro de soporte con éxito!\n");
    }

    // Método auxiliar para mostrar el contenido de la cola resultante sin alterarla
    private static void imprimirColaResultado(Cola<Solicitud> cola) {
        Cola<Solicitud> aux = cola.cloneRecursivo();
        while (!aux.isEmpty()) {
            Solicitud sol = aux.desenconlar();
            System.out.println(sol);
        }
    }
}
