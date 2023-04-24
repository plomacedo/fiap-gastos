package com.fiap.webservices.Gastos.Repository;

import com.fiap.webservices.Gastos.Entity.Expense;
import com.fiap.webservices.Gastos.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository <Expense, Long> {

    List<Expense> findByUser(User user);

}
