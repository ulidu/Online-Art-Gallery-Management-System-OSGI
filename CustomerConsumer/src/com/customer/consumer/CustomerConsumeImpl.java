package com.customer.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import com.database.service.CustomerDao;

public class CustomerConsumeImpl implements CustomerConsume{
	
	CustomerDao customerDao = null;
	HashMap<String, String> customerModel = new HashMap<>();

	public CustomerConsumeImpl(CustomerDao customerDao) {
		
		this.customerDao = customerDao;
		
	}

	@Override
	public void add() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter customer ID					: ");
		customerModel.put("customerID", scanner.nextLine());
		
		System.out.print("Enter customer name				: ");
		customerModel.put("customerName", scanner.nextLine());
		
		System.out.print("Enter customer's age		 		: ");
		customerModel.put("customerAge", Integer.toString(scanner.nextInt()));
		
		System.out.print("Enter customer's email address		: ");
		customerModel.put("customerEmail", scanner.nextLine());
		
		System.out.print("Enter customer's address			: ");
		customerModel.put("customerAddress", scanner.nextLine());
		
		System.out.print(" ");
		
		if (customerDao.save(customerModel)) {
			
			System.out.println("Customer created successfully ! ");
			
		} else {
			
			System.out.println("Something went wrong ! ");		
			
		}
		
	}

	@Override
	public void get() {
		
		System.out.print("Enter customer ID: ");
		Scanner scanner = new Scanner(System.in);

		String id = scanner.nextLine();
		Map<String, String> data = customerDao.findById(id);

		if (Objects.nonNull(data)) {
			
			data.forEach((key, value) -> System.out.println(key + ":" + value));
			System.out.println("");
			
		} else {
			
			System.out.println("Sorry, We couldn't find any Customer with ID:" + id + " !");
			System.out.println("");
			
		}
		
	}

}
