package com.sambit.customerdatamanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sambit.customerdatamanagement.Service.CustomerService;
import com.sambit.customerdatamanagement.dto.CustomerDTO;
import com.sambit.customerdatamanagement.dto.ResponseStructure;
import com.sambit.customerdatamanagement.entity.Customer;

@RestController
public class CustomerController {

	@Autowired
   private CustomerService service;

	@PostMapping("/customer")
	public @ResponseBody ResponseStructure<Customer> saveCustomer(@RequestBody CustomerDTO dto) {
		
		return service.saveCustomer(dto);
		
	}            
	
	@PutMapping("/customer")
	public @ResponseBody Customer updateCustomer(@RequestBody Customer customer) {
		
		return service.updateCustomer(customer);
		
	}
	@GetMapping(value="/customer")
   public @ResponseBody ResponseStructure<List<Customer>> getAllCustomerData() {
		
		return service.getAllCustomerData();
	}
	
	@GetMapping("/customer/{id}")
	public @ResponseBody Customer getDataById(@PathVariable("id") int id) {
		
		return service.getDataById(id);
	}
	
	@DeleteMapping("/customer")
	public @ResponseBody Customer deleteCustomerById(@RequestParam int id) {
		
	return service.deleteCustomerDataById(id);
	}
	
	@GetMapping("/customerbyname/{name}")
	public @ResponseBody List<Customer>getCustomerByName(@PathVariable("name") String name){
		
		return service.getCustomerByName(name);
		
		
	}
	
	@PostMapping("/validatecustomer")
	public List<Customer>validateCustomer(@RequestParam("name") String name,@RequestParam("email") String email){
		
		return service.validateCustomer(name, email);
		
		
		
	}
	
	
	
	
	
}
