import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
// import com.google.gson.JsonObject;

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
                .header("Accept-Language", "es-ES") // Ejemplo de header
                .timeout(Duration.ofSeconds(10)) // Timeout de 10 segundos
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar el código de estado de la respuesta
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la solicitud: " + response.statusCode());
        }

        Gson gson = new Gson();
        TasasDeCambio tasasDeCambio = gson.fromJson(response.body(), TasasDeCambio.class);

        // Filtrar las monedas
        Map<String, Double> monedasFiltradas = tasasDeCambio.getConversionRates().entrySet().stream()
        .filter(entry -> entry.getKey().equals("ARS") || entry.getKey().equals("BOB") || 
                         entry.getKey().equals("BRL") || entry.getKey().equals("CLP") || 
                         entry.getKey().equals("COP") || entry.getKey().equals("USD"))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        tasasDeCambio.setConversionRates(monedasFiltradas);

        return tasasDeCambio;

    }
}