package com.sambit.customerdatamanagement.Service;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sambit.customerdatamanagement.dto.CustomerDTO;
import com.sambit.customerdatamanagement.dto.ResponseStructure;
import com.sambit.customerdatamanagement.entity.Customer;
import com.sambit.customerdatamanagement.repository.CustomerDAO;
import com.sambit.customerdatamanagement.repository.CustomerRepository;
@Service
public class CustomerService {

	@Autowired
	private CustomerDAO dao;
	
	public ResponseStructure<Customer> saveCustomer(CustomerDTO dto) {
		Customer cus = new Customer(dto);
		Customer customer=dao.saveCustomer(cus);
		ResponseStructure<Customer> rs = new ResponseStructure<>();
		rs.setData(customer);
		rs.setStatuscode(HttpStatus.OK.value());
		rs.setMessage("Customer data saved successfully");
		rs.setTimeStamp(LocalDateTime.now());
		return rs;
		
		
		
	}

	public Customer updateCustomer(Customer customer){
		 return dao.saveCustomer(customer);
		
		
		
		
		}
	
public ResponseStructure<List<Customer>> getAllCustomerData() {
		
		 List<Customer> list= dao.getAllCustomerData();
		 ResponseStructure<List<Customer>> rs = new ResponseStructure<>();
		 
		 if(list.size()!=0) {
			
			 rs.setStatuscode(HttpStatus.FOUND.value());
			 rs.setData(list);
			 rs.setTimeStamp(LocalDateTime.now());
			 rs.setMessage("Customers entry found in database");
			 }
		 else {
			 
			 rs.setStatuscode(HttpStatus.NOT_FOUND.value());
			 rs.setData(null);
			 rs.setTimeStamp(LocalDateTime.now());
			 rs.setMessage("No Customers entry found in database ");
			 
			}
		 return rs;
		 
		 
		 
		 
		 
	}

public Customer getDataById(int id) {
	
	return dao.getCustomerDataById(id);
	
}

public Customer deleteCustomerDataById(int id) {
	
	return dao.deleteCustomerDataById(id);
}
 public List<Customer> getCustomerByName(String name){
	 throw new InputMismatchException();
	// return dao.getCustomerByName(name);
	 
 }

public List<Customer> validateCustomer(String name,String email){
	
	return dao.validateCustomer(name, email);
}


	
}
