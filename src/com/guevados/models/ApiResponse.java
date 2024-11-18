package com.guevados.models;

import java.util.List;

public class ApiResponse {
    private String result;
    private String error_type;
    private List<List<String>> supported_codes;
    private Double conversion_rate;

    public String getResult() {
        return result;
    }

    public String getError_type() {
        return error_type;
    }

    public List<List<String>> getSupportedCodes() {
        return supported_codes;
    }

    public Double getConversionRate() {
        return conversion_rate;
    }
}
