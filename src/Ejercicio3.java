import java.util.Scanner;
public class Ejercicio3 {
    public static void main(String[] args) {
        int horas, salariohora;
        double porcentajeRF;

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrse las horas trabajadas: ");
        horas = entrada.nextInt(); //se ingresa las horas trabajadas
        System.out.println("Ingrese la razon del salario por hora: ");
        salariohora = entrada.nextInt(); //se ingresa la razon del salario por hora
        System.out.println("Ingresa el porcentaje de la retención: ");
        porcentajeRF = entrada.nextDouble(); //Se ingresa el porcentaje

        int sbruto = horas * salariohora;
        double retencion = sbruto * (porcentajeRF/100);
        double sneto = sbruto - retencion;

        System.out.println("El salario bruto es: " + sbruto);
        System.out.println("La retencion de fuente es: " + retencion);
        System.out.println("El salario neto es: " + sneto);
    }

}
