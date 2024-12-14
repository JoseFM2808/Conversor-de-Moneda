import java.util.Map;

public class TasasDeCambio {
    private Map<String, Double> conversionRates;

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public void setConversionRates(Map<String, Double> conversionRates) {
        this.conversionRates = conversionRates;
    }

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        if (conversionRates.containsKey(monedaOrigen) && conversionRates.containsKey(monedaDestino)) {
            double tasaOrigen = conversionRates.get(monedaOrigen);
            double tasaDestino = conversionRates.get(monedaDestino);
            return cantidad * (tasaDestino / tasaOrigen);
        } else {
            throw new IllegalArgumentException("Monedas no válidas para la conversión.");
        }
    }
}