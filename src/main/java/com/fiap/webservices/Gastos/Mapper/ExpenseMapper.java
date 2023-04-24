package com.fiap.webservices.Gastos.Mapper;

import com.fiap.webservices.Gastos.DTO.ExpenseDTO;
import com.fiap.webservices.Gastos.Entity.Expense;

public class ExpenseMapper {

    public static ExpenseDTO maptoExpenseDTO(Expense expense) {
        ExpenseDTO expenseDTO = new ExpenseDTO(
                expense.getId(),
                expense.getDate(),
                expense.getExpenseName(),
                expense.getOriginalCurrency(),
                expense.getAmount(),
                expense.getDesiredCurrency(),
                expense.getConvertedAmount(),
                expense.getUser()
        );
        return expenseDTO;
    }

    public static Expense mapToExpense(ExpenseDTO expenseDTO) {
        Expense expense = new Expense(
                expenseDTO.getId(),
                expenseDTO.getDate(),
                expenseDTO.getExpenseName(),
                expenseDTO.getOriginalCurrency(),
                expenseDTO.getAmount(),
                expenseDTO.getDesiredCurrency(),
                expenseDTO.getConvertedAmount(),
                expenseDTO.getUser()
        );
        return expense;
    }
}
