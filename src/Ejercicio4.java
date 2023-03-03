import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
        double x;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el valor:");
        x = entrada.nextDouble();

        System.out.println("" + x + "^2 es: " + Math.pow(x, 2));
        System.out.println("" + x + "^3 es: " + Math.pow(x, 3));
    }

}
