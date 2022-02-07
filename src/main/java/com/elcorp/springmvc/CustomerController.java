package com.elcorp.springmvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/form")
	public String renderCustomerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-create";
	}
	
	@RequestMapping("/submit")
	public String processCustomer(@Valid @ModelAttribute("customer") Customer customer, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "customer-create";
		}
		else {
			return "customer-created";
		}	
	}

}
