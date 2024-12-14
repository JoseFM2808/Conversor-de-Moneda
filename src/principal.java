import java.io.IOException;
import java.util.Map;

public class principal {

    public static void main(String[] args) throws IOException, InterruptedException {
        ConsultaTipoCambio consulta = new ConsultaTipoCambio("tu_api_key");
        TasasDeCambio tasas = consulta.obtenerTasasDeCambio("USD");
        
        for (Map.Entry<String, Double> entry : tasas.getConversionRates().entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}