import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConsultaTipoCambio {

    private final String apiKey; 

    public ConsultaTipoCambio(String apiKey) {
        this.apiKey = apiKey;
    }

    public JsonObject obtenerTasasDeCambio(String monedaBase) throws IOException, InterruptedException {
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
        return gson.fromJson(response.body(), JsonObject.class);
    }
}