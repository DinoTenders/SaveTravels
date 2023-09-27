package com.SafeTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SafeTravels.models.Expenses;
import com.SafeTravels.repository.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expenses> allExpenses(){
		return expenseRepository.findAll();
	}
	
	public Expenses createExpense(Expenses expense) {
		return expenseRepository.save(expense);
	}
	
	public Expenses findExpense(Long id) {
		Optional<Expenses> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}else {
			return null;
		}
	}
	
	public Expenses updateExpense(Expenses expense) {
		return expenseRepository.save(expense);
	}
	
	public void deleteExpense(Expenses expense) {
		expenseRepository.delete(expense);
	}

}
