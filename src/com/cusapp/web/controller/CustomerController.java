package com.cusapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.cusapp.model.persistence.Customer;
import com.cusapp.model.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value = "allcustomers", method = RequestMethod.GET)
	public String getCustomers(ModelMap map) {
		map.addAttribute("customer", customerService.getAllCustomers());
		return "allcustomers";
	}
	
	@RequestMapping(value = "addcustomer", method = RequestMethod.GET)
	public String addCustomerGet(ModelMap map) {
		// adding an form bean
		map.addAttribute("customer", new Customer());
		return "addcustomer";
	}
	
	@RequestMapping(value = "addcustomer", method = RequestMethod.POST)
	public String addCustomerUpdatePost(@Valid Customer customer,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addcustomer";
		} else {

			if (customer.getCustId() == 0)
				customerService.addCustomer(customer);
			else
				customerService.updateCustomer(customer);
			return "redirect:allcustomers";
		}
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteCustomer(HttpServletRequest req) {
		int customer_Id = Integer.parseInt(req.getParameter("id"));
		customerService.removeCustomer(customer_Id);
		return "redirect:allcustomers";
	}
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateCustomerGet(HttpServletRequest req, ModelMap map) {
		int customerId = Integer.parseInt(req.getParameter("id"));
		Customer customerToBeUpdate = customerService.getCustomerById(customerId);
		System.out.println(customerToBeUpdate);
		map.addAttribute("customer", customerToBeUpdate);
		return "addcustomer";
	}

}
