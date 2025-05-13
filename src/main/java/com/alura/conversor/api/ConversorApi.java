package com.alura.conversor.api;

import com.alura.conversor.modelos.Moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConversorApi {

    private final HttpClient client;
        public ConversorApi() {
            client = HttpClient.newHttpClient();
        }


    public double findAll(String base, String destino, double monto) throws IOException, InterruptedException {
         final String BASE_URL = "https://v6.exchangerate-api.com/v6/d07e82dd0324b23553ebfc05/pair/";

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL + "/" + base + "/" + destino + "/" + monto))
            .GET()
            .build();


        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Moneda resObject = new Gson().fromJson(response.body(), Moneda.class);
            return resObject.conversion_result();
            } catch (Exception e) {
                throw new RuntimeException("No se pudo obtener la conversión.");
            }


    }
}
