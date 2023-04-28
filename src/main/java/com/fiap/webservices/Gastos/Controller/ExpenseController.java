package com.fiap.webservices.Gastos.Controller;

import com.fiap.webservices.Gastos.DTO.ExpenseDTO;
import com.fiap.webservices.Gastos.Model.Expense;
import com.fiap.webservices.Gastos.Services.ExpenseService;
import com.fiap.webservices.Gastos.Services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/expenses")
@Api(value="API REST Expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @PostMapping
    @ApiOperation(value="this method creates a new expense")
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO savedExpense = expenseService.createExpense(expenseDTO);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation(value="this method returns the list of all expenses")
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
        List<ExpenseDTO> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Expense>> getExpenseByUserId(@PathVariable Long userId) {
        List<Expense> expense = expenseService.getExpenseByUserId(userId);
        return ResponseEntity.ok(expense);
    }

    @GetMapping("/{userId}/report")
    public ResponseEntity<byte[]> createExpenseReport(@PathVariable Long userId) throws IOException {

        List<Expense> expensesList = expenseService.getExpenseByUserId(userId);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        writer.write("ID,Card Number,Value, Type, Date\n");
        for (Expense expense : expensesList) {
            writer.write(String.format("%d,%s,%s,%.2f,%s,%.2f,%s", expense.getId(),expense.getDate(),expense.getExpenseName(),expense.getAmount(),expense.getOriginalCurrency(),expense.getConvertedAmount(),expense.getDesiredCurrency()));
            writer.newLine();
        }

        writer.flush();
        writer.close();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=expenses_user_%s.csv", userId));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(outputStream.toByteArray().length)
                .contentType( MediaType.parseMediaType("application/octet-stream"))
                .body(outputStream.toByteArray());

    }



}
