package com.fiap.webservices.Gastos.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String expenseName;

    @Column(nullable = false)
    private String originalCurrency;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String desiredCurrency;

    @Column(nullable = false)
    private double convertedAmount;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Expense(Long id, Date date, String expenseName, String originalCurrency, double amount, String desiredCurrency, double convertedAmount, User user) {
        this.id = id;
        this.date = date;
        this.expenseName = expenseName;
        this.originalCurrency = originalCurrency;
        this.amount = amount;
        this.desiredCurrency = desiredCurrency;
        this.convertedAmount = convertedAmount;
        this.user = user;
    }

    public Expense() {
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
