package com.fiap.webservices.Gastos.Repository;

import com.fiap.webservices.Gastos.Model.Expense;
import com.fiap.webservices.Gastos.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository <Expense, Long> {

    List<Expense> findByUser(User user);

}
