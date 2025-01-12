package org.example;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionCurrency {
    String exchangeConverter(String base_code, String target_code, double amount) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");

        URI direction = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey  + "/pair/" + base_code + "/" + target_code +"/"+amount);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        var jsonResponse = new Gson().fromJson(response.body(), Currency.class);

        //return new Gson().fromJson(response.body(), Currency.class);
        return "El valor " + amount + " [" + jsonResponse.base_code() + "]" + " corresponde al valor final de =>> " + jsonResponse.conversion_result() + " [" + jsonResponse.target_code() + "]";
    }
}
