package com.currencyconverter.connection;

import com.currencyconverter.models.CurrencyDTO;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

public class Post implements Serializable {

    private String name;
    private double valueInEuros;
    private RestTemplate restTemplate;

    public Post(RestTemplate restTemplate) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValueInEuros() {
        return valueInEuros;
    }

    public void setValueInEuros(double valueInEuros) {
        this.valueInEuros = valueInEuros;
    }

    public CurrencyDTO getPostsAsObject() {
        String url = "https://www.lb.lt/webservices/FxRates/";
        return this.restTemplate.getForObject(url, CurrencyDTO.class);
    }
}
