package com.cg.in.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.in.entities.Transaction;
import com.cg.in.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	private final TransactionRepository transactionRepository;
	@Autowired
	public TransactionServiceImpl(TransactionRepository transactionRepository)
	{
		this.transactionRepository=transactionRepository;
	}
	
	@Override
	public void addTransaction(Transaction transaction) {
		
		transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> getTransactionsByAccountId(int accountNum) {
		
		return transactionRepository.findByAccountNum(accountNum);
	}

}
