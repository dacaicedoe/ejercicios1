import java.util.Scanner;
public class Ejercicio5 {
    public static void main(String[] args) {
        double radio;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el valor del radio:");
        radio = entrada.nextDouble();

        double area = Math.PI * (Math.pow(radio, 2));
        double circunferencia = 2*Math.PI * radio;

        System.out.println("El área del circulo es: "+ area);
        System.out.println("El longitud de la circunferencia es: "+ circunferencia);


    }

}
