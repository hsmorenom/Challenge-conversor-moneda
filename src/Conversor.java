
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    Monedas obtenerTasas() {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/43d9f92d52f6f0d9ecde2ef0/latest/USD");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            return new Monedas(
                    conversionRates.get("BRL").getAsDouble(),
                    conversionRates.get("PEN").getAsDouble(),
                    conversionRates.get("COP").getAsDouble(),
                    conversionRates.get("ARS").getAsDouble()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las tasas de cambio", e);
        }
    }
}
