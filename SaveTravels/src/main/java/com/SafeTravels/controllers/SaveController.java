package com.SafeTravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SafeTravels.models.Expenses;
import com.SafeTravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
public class SaveController {
	@Autowired
	ExpenseService expenseService;
		
	@GetMapping("/")
	public String home() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String Main(@ModelAttribute("expense") Expenses expense, Model model) {
		List<Expenses> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "Main";
	}
	
	@PostMapping("/expenses")
	public String index(@Valid @ModelAttribute("expense") Expenses expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expenses> expenses = expenseService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "Main";
		}else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}

	@GetMapping("/expenses/{id}")
	public String showExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "View";
		}
	
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("expense", expenseService.findExpense(id));
		return "Editor";
	}
	
	@PostMapping("/expenses/edit/{id}")
	public String update(
			@PathVariable("id") Long id, 
			Model model, 
			@Valid @ModelAttribute("expense") Expenses expense, 
			BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expenseService.findExpense(id));
			return "redirect:/edit/{id}";
		}else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@RequestMapping("/expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		Expenses expense = expenseService.findExpense(id);
		expenseService.deleteExpense(expense);
		return "redirect:/expenses";
	}
		
}