package com.guevados.models;

public class Currency implements Comparable<Currency>{
    private String currencyCode;
    private String currencyName;
    private String country;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "currency [\ncode = "+ currencyCode +",\nname = " + currencyName + ",\ncountry = " + country +"]";
    }

    @Override
    public int compareTo(Currency o) {
        return this.currencyCode.compareTo(o.currencyCode);
    }
}

