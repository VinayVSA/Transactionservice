package com.cg.in.services;

import java.util.List;

import com.cg.in.entities.Transaction;



public interface TransactionService {

	void addTransaction(Transaction transaction);

    List<Transaction> getTransactionsByAccountId(int accountNum);
}
