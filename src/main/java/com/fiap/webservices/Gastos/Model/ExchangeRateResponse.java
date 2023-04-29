package com.fiap.webservices.Gastos.Model;

import java.util.Date;
import java.util.Map;

public class ExchangeRateResponse {
    private boolean success;
    private CurrencyConversionRequest query;
    private ExchangeRateInfo info;
    private Date date;
    private double result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public CurrencyConversionRequest getQuery() {
        return query;
    }

    public void setQuery(CurrencyConversionRequest query) {
        this.query = query;
    }

    public ExchangeRateInfo getInfo() {
        return info;
    }

    public void setInfo(ExchangeRateInfo info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}