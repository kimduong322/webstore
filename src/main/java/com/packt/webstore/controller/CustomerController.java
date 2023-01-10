package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
	public String list(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}
	@RequestMapping(value="/customers/add", method=RequestMethod.GET)
	public String getAddNewCustomerForm(Model model) {
		Customer newCustomer = new Customer();
		model.addAttribute("newCustomer", newCustomer);
		return "addCustomer";
	}
	
	@RequestMapping(value="/customers/add", method=RequestMethod.POST)
	public String processAddNewCustomerForm(@ModelAttribute("newCustomer") Customer customerToBeAdded) {
		customerService.addCustomer(customerToBeAdded);
		return "redirect:/customers";
	}
}
