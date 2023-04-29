package com.fiap.webservices.Gastos.Model;

public class ExchangeRateInfo {
    private Number timestamp;
    private double rate;

    public Number getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Number timestamp) {
        this.timestamp = timestamp;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
