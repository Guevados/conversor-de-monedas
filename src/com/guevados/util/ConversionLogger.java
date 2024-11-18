package com.guevados.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConversionLogger {
    private static final String FILE_PATH = "db.json";
    private final Gson gson;

    public ConversionLogger(){
        this.gson = new Gson();
    }

    public void logConversion(String fromCurrency, String toCurrency, double amount){
        File file = new File(FILE_PATH);
        JsonArray conversionList;

        try{
            if ( file.exists()){
                FileReader reader = new FileReader(file);
                conversionList = JsonParser.parseReader(reader).getAsJsonArray();
                reader.close();
            } else {
                conversionList = new JsonArray();
            }

            JsonObject conversionEntry = new JsonObject();
            conversionEntry.addProperty("fromCurrency", fromCurrency);
            conversionEntry.addProperty("toCurrency", toCurrency);
            conversionEntry.addProperty("amount", amount);
            conversionEntry.addProperty("index", conversionList.size() + 1);

            conversionList.add(conversionEntry);

            FileWriter writer = new FileWriter(file);
            gson.toJson(conversionList, writer);
            writer.flush();
            writer.close();

            System.out.println("Conversion registrada con exito en " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
