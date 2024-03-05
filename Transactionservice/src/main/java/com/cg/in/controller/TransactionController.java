package com.cg.in.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.in.entities.Transaction;
import com.cg.in.services.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addTransaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byAccount/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionsByAccountId(@PathVariable int accountId) {
        List<Transaction> transactions = transactionService.getTransactionsByAccountId(accountId);
        return ResponseEntity.ok(transactions);
    }
	

}
