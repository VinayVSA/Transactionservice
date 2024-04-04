package com.cg.in.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
    @GetMapping("/admin/byAccount")
    public ModelAndView getTransactionsByAccountid() {
    	  return new ModelAndView("transactionbyid");
    }
    
    @GetMapping("/byAccount")
    public ModelAndView getTransactionsByAccountid(@RequestParam("id") int id) {
    	List<Transaction> transactions = transactionService.getTransactionsByAccountId(id);
    	ModelAndView mv=new ModelAndView("transactionbyid");
        
        mv.addObject("transactions", transactions);
        return mv;
    }

}
