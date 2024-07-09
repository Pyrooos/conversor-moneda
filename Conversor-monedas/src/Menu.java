import java.util.List;
import java.util.Scanner;

public class Menu {
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Conversor de Monedas");
        System.out.println("Obteniendo las divisas soportadas...");

        try {
            List<String[]> divisasSoportadas = API.obtenerDivisasSoportadas();
            System.out.println("Divisas soportadas:");
            for (String[] moneda : divisasSoportadas) {
                System.out.println(moneda[0] + " - " + moneda[1]);
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener las divisas soportadas: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        System.out.print("Ingrese la divisa de origen (por ejemplo, USD): ");
        String divisaDesde = scanner.next().toUpperCase();

        System.out.print("Ingrese la divisa de destino (por ejemplo, EUR): ");
        String divisaHasta = scanner.next().toUpperCase();

        System.out.print("Ingrese la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        try {
            ConversorDivisas conversor = new ConversorDivisas();
            double resultado = conversor.convertir(cantidad, divisaDesde, divisaHasta);
            System.out.println(cantidad + " " + divisaDesde + " equivale a " + resultado + " " + divisaHasta);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la conversión: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
