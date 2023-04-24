package com.fiap.webservices.Gastos.DTO;

import com.fiap.webservices.Gastos.Entity.User;
import java.util.Date;

public class ExpenseDTO {

    private Long id;
    private Date date;
    private String expenseName;
    private String originalCurrency;
    private double amount;
    private String desiredCurrency;
    private double convertedAmount;
    private User user;

    public ExpenseDTO(Long id, Date date, String expenseName, String originalCurrency, double amount, String desiredCurrency, double convertedAmount, User user) {
        this.id = id;
        this.date = date;
        this.expenseName = expenseName;
        this.originalCurrency = originalCurrency;
        this.amount = amount;
        this.desiredCurrency = desiredCurrency;
        this.convertedAmount = convertedAmount;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDesiredCurrency() {
        return desiredCurrency;
    }

    public void setDesiredCurrency(String desiredCurrency) {
        this.desiredCurrency = desiredCurrency;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
