package com.wipro.customermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.wipro.customermanagement.entity.Customer;
import com.wipro.customermanagement.repository.CustomerRepository;
import com.wipro.customermanagement.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;

	@Autowired
	private CustomerRepository repo;

	@Autowired
	private Customer customer;

	@RequestMapping("/login")
	@ResponseBody
	public String LoginMessage() {
		return "Hello World";
	}

	@RequestMapping(value = "/CustomerManager", method = RequestMethod.GET)
	public String showCustomerManager(Model model) {
		List<Customer> findAll = repo.findAll();
		model.addAttribute("customers", findAll);
		return "customersDetailsPage";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String addCustomer(Model model) {
		model.addAttribute("customer", customer);
		return "addCustomer";
	}

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		repo.save(customer);
		return "redirect:/CustomerManager";
	}
	@RequestMapping(value="/searchCustomer",method = RequestMethod.GET)
	public String searchCustomer(@RequestParam int id, Model model) {
		      Customer searchCust = repo.getOne(id);
		      if(searchCust==null) {
		    	  model.addAttribute("errorCustomer","Invalid Customer ID");
		    	  return "redirect:/CustomerManager"; 
		      }
		    model.addAttribute("searchCust", searchCust);      
		    return "redirect:/CustomerManager";
	}

	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public String editCustomer(@RequestParam int id, Model model) {
		Customer customer = repo.getOne(id);
        model.addAttribute("customer",customer);
		return "editCustomer";
	}
	
	@RequestMapping(value = "/editSaveCustomer", method = RequestMethod.POST)
	public String editCustomer(@RequestParam int id,@ModelAttribute("customer") Customer customer) {
	     repo.save(customer);
		return "redirect:/CustomerManager";
	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam int id) {
		Customer cust = service.findOne(id);
		service.remove(cust);
		return "redirect:/CustomerManager";
	}

}
