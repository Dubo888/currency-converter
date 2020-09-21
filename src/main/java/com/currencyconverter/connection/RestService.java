package com.currencyconverter.connection;

import com.currencyconverter.models.CurrencyDTO;
import com.currencyconverter.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    @Autowired
    private CurrencyRepository currencyRepository;

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    public CurrencyDTO getPostsPlainJSON() {
        String url = "https://www.lb.lt/webservices/FxRates/";
        return this.restTemplate.getForObject(url, CurrencyDTO.class);
    }
}
