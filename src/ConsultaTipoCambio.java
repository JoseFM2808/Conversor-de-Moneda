import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), JsonObject.class);
    }
}