package com.guevados.principal;

import com.guevados.util.ApiClient;
import com.guevados.util.ConversionLogger;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ApiClient apiClient = new ApiClient();
        Scanner scanner = new Scanner(System.in);
        ConversionLogger logger = new ConversionLogger();
        boolean exit = false;

        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, () -> App.listCurrencies(apiClient));
        actions.put(2, () -> App.convertCurrency(apiClient, scanner, logger));
        actions.put(3, () -> {
            System.out.println("Gracias por usar el conversor de monedas");
            App.exit();
        });

        while (!exit) {

            System.out.println("--------------------------------");
            System.out.println("Bienvenido al conversor de monedas");
            System.out.println("--------------------------------");
            System.out.println("Ingrese su opcion: \n1 - para listar monedas \n2 - para convertir de una moneda a otra \n3 - para salir");
            System.out.println("--------------------------------\n");

            int option = scanner.nextInt();
            scanner.nextLine();

            Runnable action = actions.get(option);
            if (action != null){
                action.run();
                if (option == 3){
                    exit = true;
                }
            } else {
                System.out.println("Escoja una opcion valida.!");
                System.out.println("--------------------------------");
            }

        }
        scanner.close();
    }
}