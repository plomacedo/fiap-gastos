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
        ExchangeRateResponse exchangeRateResponse = exchangeRateService.getExchangeRates();

        if (exchangeRateResponse != null && exchangeRateResponse.getRates() != null) {
            double fromRate = exchangeRateResponse.getRates().get(request.getFrom());
            double toRate = exchangeRateResponse.getRates().get(request.getTo());


            double a = (request.getAmount() / fromRate) * toRate;
            System.out.println("Valor %.2f"+ a);
            System.out.println(request);
            System.out.println("de"+fromRate);
            System.out.println("para"+toRate);

            return (request.getAmount() / fromRate) * toRate;
        } else {
            throw new RuntimeException("Não foi possível obter as taxas de câmbio da API");
        }
    }
}