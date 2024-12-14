import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class principal {

    public static void main(String[] args) throws IOException, InterruptedException {
        ConsultaTipoCambio consulta = new ConsultaTipoCambio("tu_api_key");
        TasasDeCambio tasas = consulta.obtenerTasasDeCambio("USD");
        
        for (Map.Entry<String, Double> entry : tasas.getConversionRates().entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
        }

         Scanner scanner = new Scanner(System.in);

         System.out.print("Ingrese la moneda de origen: ");
         String monedaOrigen = scanner.nextLine().toUpperCase();
 
         System.out.print("Ingrese la moneda de destino: ");
         String monedaDestino = scanner.nextLine().toUpperCase();
 
         System.out.print("Ingrese la cantidad a convertir: ");
         double cantidad = scanner.nextDouble();
 
         try {
             double resultado = tasas.convertir(monedaOrigen, monedaDestino, cantidad);
             System.out.println(cantidad + " " + monedaOrigen + " = " + resultado + " " + monedaDestino);
         } catch (IllegalArgumentException e) {
             System.out.println(e.getMessage());
         }
     }
}