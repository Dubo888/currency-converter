package com.currencyconverter.connection;

import com.currencyconverter.models.CurrencyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ResponseHandling {

    private RestTemplate restTemplate;

    public CurrencyDTO getPostWithResponseHandling() {
        String url = "https://www.lb.lt/webservices/FxRates/";
        ResponseEntity<CurrencyDTO> response = this.restTemplate.getForEntity(url, CurrencyDTO.class);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }


}
