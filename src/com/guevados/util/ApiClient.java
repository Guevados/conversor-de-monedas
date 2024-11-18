package com.guevados.util;

import com.google.gson.Gson;
import com.guevados.models.ApiResponse;
import com.guevados.models.Currency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiClient {
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "a37d012ff86d2f9fe535f230";
    private final HttpClient client;
    private final Gson gson;

    public ApiClient(){
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    private ApiResponse handleApiResponse(HttpResponse<String> response) throws Exception{
        if (response.statusCode() == 200) {
            ApiResponse apiResponse = gson.fromJson(response.body(), ApiResponse.class);
            if (!"success".equals(apiResponse.getResult())){
                throw new Exception("API Error: " + response.statusCode());
            }
            return apiResponse;
        } else {
            throw new Exception("HTTP Error: " + response.statusCode());
        }
    }

    public void listCurrencies() {
        String endpoint = BASE_URL + API_KEY + "/codes";

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(endpoint))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            ApiResponse apiResponse = handleApiResponse(response);

            List<Currency> currencies = apiResponse
                    .getSupportedCodes()
                    .stream()
                    .map(codeArray -> new Currency(codeArray.getFirst(), codeArray.get(1)))
                    .toList();

            currencies.forEach(System.out::println);

        } catch (IOException | InterruptedException e) {
            System.out.println("Network Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void convertCurrency(String fromCurrency, String toCurrency, double amount){
        String endpoint = BASE_URL + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency;
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(endpoint))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ApiResponse apiResponse = handleApiResponse(response);

            if (apiResponse.getConversionRate() != null) {
                double convertedAmount = apiResponse.getConversionRate() * amount;
                System.out.println("Converted amount: " + convertedAmount + " " + toCurrency);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Network Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}