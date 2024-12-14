import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConsultaTipoCambio {

    private final String apiKey;

    public ConsultaTipoCambio(String apiKey) {
        this.apiKey = apiKey;
    }

    public TasasDeCambio obtenerTasasDeCambio(String monedaBase) throws IOException, InterruptedException {
        String url_str = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase;
        URI uri = URI.create(url_str);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept-Language", "es-ES")
                .timeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la solicitud: " + response.statusCode());
        }

        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);

        JsonObject conversionRatesJson = jsonObject.getAsJsonObject("conversion_rates");

        Map<String, Double> conversionRates = gson.fromJson(conversionRatesJson, Map.class);

        TasasDeCambio tasasDeCambio = new TasasDeCambio(conversionRates);

        Map<String, Double> monedasFiltradas = tasasDeCambio.getConversionRates().entrySet().stream()
                .filter(entry -> entry.getKey().equals("ARS") || entry.getKey().equals("BOB") ||
                        entry.getKey().equals("BRL") || entry.getKey().equals("CLP") ||
                        entry.getKey().equals("COP") || entry.getKey().equals("USD"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        tasasDeCambio.setConversionRates(monedasFiltradas);

        return tasasDeCambio;

    }
}