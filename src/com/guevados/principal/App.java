package com.guevados.principal;

import com.guevados.util.ApiClient;
import com.guevados.util.ConversionLogger;

import java.util.Scanner;

public class App {
    public static void listCurrencies(ApiClient apiClient){
        try {
            apiClient.listCurrencies();
        } catch (Exception e) {
            System.out.println("Error al listar monedas: " + e.getMessage());
        }
        System.out.println("---------------------------------");
    }

    public static void convertCurrency(ApiClient apiClient, Scanner scanner, ConversionLogger logger){
        try {
            System.out.println("Escriba el codigo de 3 letras de tu moneda base");
            String currencyBase = scanner.nextLine();

            System.out.println("Escriba el codigo de 3 letras de la moneda a convertir");
            String currencyConvert = scanner.nextLine();

            System.out.println("Escriba el monto a convertir");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            apiClient.convertCurrency(currencyConvert, currencyBase, amount);

            logger.logConversion(currencyConvert, currencyBase, amount);
        } catch(Exception e){
            System.out.println("Error al convertir moneda: " + e+ e.getMessage());
        }
        System.out.println("---------------------------------");
    }

    public static void exit(){
        System.out.println("--------------------------------");
        System.out.println("Finalizando conversor...");
        System.out.println("--------------------------------");
    }
}
