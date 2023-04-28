package com.fiap.webservices.Gastos.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.webservices.Gastos.Model.ExchangeRateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ExchangeRateService {
    private final String API_URL = "https://api.exchangeratesapi.io/v1/";

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public ExchangeRateService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ExchangeRateResponse getExchangeRates() throws IOException {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(API_URL, String.class);
        String responseString = responseEntity.getBody();

        ExchangeRateResponse exchangeRateResponse = objectMapper.readValue(responseString, ExchangeRateResponse.class);



        return exchangeRateResponse;
    }
}
