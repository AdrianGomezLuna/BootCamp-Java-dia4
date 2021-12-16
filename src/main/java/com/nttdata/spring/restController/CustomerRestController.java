package com.nttdata.spring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.spring.repository.NTTDataCustomer;
import com.nttdata.spring.services.NTTDataCustomerManagementServiceI;

@RestController
@RequestMapping("/rest")
public class CustomerRestController {
	
	@Autowired
	private NTTDataCustomerManagementServiceI customerService;
	
	
	/**
	 * Devuelve todos los clientes
	 * @return listado de los clientes
	 */
	@GetMapping
	public List<NTTDataCustomer> addCustomer() {
		return customerService.searchAllCustomers2();
	}
	
	/**
	 * Método que agrega un nuevo cliente
	 * 
	 * @param nuevo cliente
	 */
	@PostMapping
	public void insertCustomer(@RequestBody NTTDataCustomer newCustomer) {
		customerService.insertNewCustomer(newCustomer);
	}
	
	/**
	 * Método que borraría un cliente por un ID pasado por parámetro
	 * @param id correspondiente al cliente que será eliminado
	 */
	@DeleteMapping(value = "/{id}" )
	public void deleteCustomer(@PathVariable Long id) {
		//customerService.delete(id);
	}
	
	/**
	 * Método que busca por nombre
	 * @param name
	 * @return
	 */
	@RequestMapping(path="/name", method = RequestMethod.GET, consumes = "application/json" )
	public List<NTTDataCustomer> searchByName(@RequestBody String name) {
		return customerService.searchByName2(name);
	}
	
	

}
