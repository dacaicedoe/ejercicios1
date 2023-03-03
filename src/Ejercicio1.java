import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la edad de Juan: ");
        double edadJuan = sc.nextDouble();

        double edadAlberto = edadJuan * 2 / 3;
        double edadAna = edadJuan * 4 / 3;
        double edadMadre = edadJuan + edadAlberto + edadAna;

        System.out.println("La edad de Juan es: " + edadJuan);
        System.out.println("La edad de Alberto es: " + edadAlberto);
        System.out.println("La edad de Ana es: " + edadAna);
        System.out.println("La edad de la madre es: " + edadMadre);
    }
}
