package com.alura.conversor.api;

import com.alura.conversor.modelos.Moneda;
import com.alura.conversor.utilidades.Colores;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConversorApi {


    private final HttpClient client;
    private final String apiKey;

    public ConversorApi() {
            client = HttpClient.newHttpClient();
            Dotenv dotenv = Dotenv.load();
            apiKey = dotenv.get("API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new RuntimeException(Colores.ROJO + "⚠️ No se encontró la API_KEY. Asegurate de tener el archivo .env con API_KEY=tu_clave");
        }
    }


    public double findAll(String base, String destino, double monto) throws IOException, InterruptedException {
         final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/";

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "/" + base + "/" + destino + "/" + monto))
            .GET()
            .build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moneda resObject = new Gson().fromJson(response.body(), Moneda.class);
            return resObject.conversion_result();
            } catch (Exception e) {
                throw new RuntimeException(Colores.ROJO + "No se pudo obtener la conversión.");
            }


    }
}
