package com.fiap.webservices.Gastos.Services;

import com.fiap.webservices.Gastos.DTO.ExpenseDTO;
import com.fiap.webservices.Gastos.Model.Expense;
import com.fiap.webservices.Gastos.Model.User;
import com.fiap.webservices.Gastos.Mapper.ExpenseMapper;
import com.fiap.webservices.Gastos.Repository.ExpenseRepository;
import com.fiap.webservices.Gastos.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        Expense entity = ExpenseMapper.mapToExpense(expenseDTO);
        Expense savedExpense = expenseRepository.save(entity);
        ExpenseDTO savedExpenseDTO = ExpenseMapper.maptoExpenseDTO(savedExpense);
        return savedExpenseDTO;
    }

    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> entities = expenseRepository.findAll();
        return entities.stream().map( ExpenseMapper::maptoExpenseDTO)
                .collect( Collectors.toList());
    }

    public List<Expense> getExpenseByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("user with id " + userId + " not found"));
        return expenseRepository.findByUser(user);
    }




}
