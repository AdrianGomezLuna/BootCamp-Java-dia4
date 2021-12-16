package com.nttdata.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;
import com.nttdata.spring.repository.NTTDataCustomer;
import com.nttdata.spring.services.NTTDataCustomerManagementServiceI;

@Controller
@RequestMapping("/home")
public class CustomerController {
	
	@Autowired
	private NTTDataCustomerManagementServiceI customerService;
	
	
	@GetMapping("/home")
	public String mostrarHome() {
		return "/home";
	}
	
	//MUESTRA LOS CLIENTES
	
	@GetMapping("/mostrarTodo")
	public String mostrarTodo(Model NTTDataCustomer) {

		List<NTTDataCustomer> lista = customerService.searchAllCustomers2();

		NTTDataCustomer.addAttribute("customer", lista);
		return "mostrarTodo";
	}
	
	
	
	//CREACIÓN NUEVO CLIENTE
	
	@GetMapping("/createCustomer")
	public String saveCustomer() {
				
		return "/createCustomer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute NTTDataCustomer newCustomer, Model model) {
		
		model.addAttribute(newCustomer);
		
		customerService.insertNewCustomer(newCustomer);
		
		return "/home";
	}
	

	

}
