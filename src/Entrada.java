import java.util.Scanner;

public class Entrada {
    private static final Scanner teclado = new Scanner(System.in);

    public static String linea(String pregunta) {
        System.out.print(pregunta + ": ");
        return teclado.nextLine().trim();
    }

    public static String texto(String pregunta) {
        String valor = linea(pregunta);
        if (valor.isEmpty()) throw new IllegalArgumentException("Escriba un valor para " + pregunta + ".");
        return valor;
    }

    public static int entero(String pregunta) {
        try {
            return Integer.parseInt(texto(pregunta));
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(pregunta + " requiere un entero.");
        }
    }

    public static int noNegativo(int valor, String campo) {
        if (valor < 0) throw new IllegalArgumentException("Valor negativo para " + campo + ".");
        return valor;
    }
}
