import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class principal {

    public static void main(String[] args) throws IOException, InterruptedException {
        ConsultaTipoCambio consulta = new ConsultaTipoCambio("0e6f6acfb62e647fde986ba3");
        TasasDeCambio tasas = consulta.obtenerTasasDeCambio("USD");

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("\n--- Conversor de Monedas ---");
            System.out.println("1. Convertir monedas");
            System.out.println("2. Mostrar tasas de cambio");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    String monedaOrigen;
                    do {
                        System.out.print("Ingrese la moneda de origen (ARS, BOB, BRL, CLP, COP, USD): ");
                        monedaOrigen = scanner.nextLine().toUpperCase();
                    } while (!monedaOrigen.equals("ARS") && !monedaOrigen.equals("BOB") &&
                            !monedaOrigen.equals("BRL") && !monedaOrigen.equals("CLP") &&
                            !monedaOrigen.equals("COP") && !monedaOrigen.equals("USD"));

                    String monedaDestino;
                    do {
                        System.out.print("Ingrese la moneda de destino (ARS, BOB, BRL, CLP, COP, USD): ");
                        monedaDestino = scanner.nextLine().toUpperCase();
                    } while (!monedaDestino.equals("ARS") && !monedaDestino.equals("BOB") &&
                            !monedaDestino.equals("BRL") && !monedaDestino.equals("CLP") &&
                            !monedaDestino.equals("COP") && !monedaDestino.equals("USD"));

                    double cantidad;
                    do {
                        System.out.print("Ingrese la cantidad a convertir (número positivo): ");
                        while (!scanner.hasNextDouble()) {
                            System.out.println("Entrada inválida. Ingrese un número.");
                            scanner.next();
                        }
                        cantidad = scanner.nextDouble();
                    } while (cantidad <= 0);

                    try {
                        double resultado = tasas.convertir(monedaOrigen, monedaDestino, cantidad);
                        System.out.println(cantidad + " " + monedaOrigen + " = " + resultado + " " + monedaDestino);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    for (Map.Entry<String, Double> entry : tasas.getConversionRates().entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}