import java.util.Scanner;

public class Console {

    private static Scanner leitor = new Scanner(System.in);

    public static int lerInt() {
        int valor = leitor.nextInt();
        leitor.nextLine();
        return valor;
    }

    public static float lerFloat() {
        float valor = leitor.nextFloat();
        leitor.nextLine();
        return valor;
    }

    public static String lerString() {
        return leitor.nextLine();
    }

    public static void fecharScanner() {
        throw new UnsupportedOperationException("Unimplemented method 'fecharScanner'");
    }

     public static void limparBuffer() {
        throw new UnsupportedOperationException("Unimplemented method 'limparBuffer'");
    }
}


