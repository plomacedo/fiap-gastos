package com.fiap.webservices.Gastos.Controller;

import com.fiap.webservices.Gastos.Model.CurrencyConversionRequest;
import com.fiap.webservices.Gastos.Model.ExchangeRateResponse;
import com.fiap.webservices.Gastos.Services.ExchangeRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@Api(value="API Currency Expenses")
public class CurrencyConverterController {
    private ExchangeRateService exchangeRateService;

    public CurrencyConverterController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @PostMapping("/convert")
    @ApiOperation(value="this method converts a new expense")
    public double convertCurrency(@RequestBody CurrencyConversionRequest request) throws IOException {

        ExchangeRateResponse exchangeRateResponse = exchangeRateService.getExchangeRates(request.getFrom(), request.getTo(), request.getAmount());

        if (exchangeRateResponse != null && exchangeRateResponse.isSuccess()) {
            System.out.println("Valor %.2f"+ exchangeRateResponse.getQuery().getAmount());
            System.out.println(request);
            System.out.println("de " + exchangeRateResponse.getQuery().getFrom());
            System.out.println("para " + exchangeRateResponse.getQuery().getTo());

            return exchangeRateResponse.getResult();
        } else {
            throw new RuntimeException("Não foi possível obter as taxas de câmbio da API");
        }
    }
}