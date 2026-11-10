package model;

import java.util.Scanner;

public class Input {

    private static final Scanner sc = new Scanner(System.in);

    // ==========================
    // ENTEROS
    // ==========================

    public static int ingresarEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número entero válido.");
            }
        }
    }

    public static short ingresarShort(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Short.parseShort(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número short válido.");
            }
        }
    }

    public static byte ingresarByte(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Byte.parseByte(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número byte válido.");
            }
        }
    }

    public static long ingresarLong(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Long.parseLong(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número long válido.");
            }
        }
    }

    // ==========================
    // DECIMALES
    // ==========================

    public static float ingresarFloat(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número decimal válido.");
            }
        }
    }

    public static double ingresarDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número decimal válido.");
            }
        }
    }

    // ==========================
    // TEXTO
    // ==========================

    public static String ingresarTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public static char ingresarChar(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine();

            if (texto.length() == 1) {
                return texto.charAt(0);
            }

            System.out.println("Error: ingrese un solo carácter.");
        }
    }

    // ==========================
    // BOOLEAN
    // ==========================

    public static boolean ingresarBoolean(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (y/n): ");
            String texto = sc.nextLine().trim().toLowerCase();

            if (texto.equals("y"))
                return true;

            if (texto.equals("n"))
                return false;

            System.out.println("Error: escribe true o false.");
        }
    }
}

