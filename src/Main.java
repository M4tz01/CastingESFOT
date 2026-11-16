import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        while (true) {
            System.out.println("\n--- TIEMPO DE ESTUDIO ---");
            System.out.println("1. Convertir minutos de estudio");
            System.out.println("2. Salir");
            try {
                switch (Entrada.entero("Opción")) {
                    case 1 -> {
                        String texto = Entrada.texto("Minutos estudiados");
                        int minutos;
                        try {
                            minutos = Integer.parseInt(texto);
                        } catch (NumberFormatException error) {
                            throw new IllegalArgumentException("Ingrese los minutos como entero.");
                        }
                        Entrada.noNegativo(minutos, "minutos");
                        double minutosDecimales = minutos;           // Implícito: int a double.
                        double horas = minutosDecimales / 60;
                        int horasCompletas = (int) horas;            // Explícito: descarta la fracción.
                        String etiqueta = String.valueOf(horasCompletas); // Primitivo a String.
                        System.out.printf("Minutos como double: %.1f%nHoras decimales: %.2f%n", minutosDecimales, horas);
                        System.out.println("Horas completas (texto): " + etiqueta);
                    }
                    case 2 -> { return; }
                    default -> System.out.println("Opción no válida.");
                }
            } catch (IllegalArgumentException error) {
                System.out.println("Error: " + error.getMessage());
            } catch (NoSuchElementException fin) {
                return;
            }
        }
    }

}
