package com.fiap.webservices.Gastos.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.webservices.Gastos.Model.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class ExchangeRateService {
    @Value( "${exchange.currency.rate_url}" )
    private String API_URL;
    @Value( "${exchange.currency.rate_key}" )
    private String API_KEY;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public ExchangeRateService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public ExchangeRateResponse getExchangeRates(String from, String to, double amount) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", API_KEY);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        String finalUrl = String.format(API_URL, to, from, amount);
        ResponseEntity<String> responseEntity = restTemplate.exchange(finalUrl, HttpMethod.GET, requestEntity, String.class);
        String responseString = responseEntity.getBody();

        ExchangeRateResponse exchangeRateResponse = objectMapper.readValue(responseString, ExchangeRateResponse.class);

        return exchangeRateResponse;
    }
}
