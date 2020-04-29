package com.example.MongodbApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongodbAppApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository custRepo;

	public static void main(String[] args) {
		SpringApplication.run(MongodbAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		create customers
		Customer c1=new Customer("1","susmit","patil");
		Customer c2=new Customer("2","sandeep","patil");
		Customer c3=new Customer("3","swati","patil");
//save into the customer repo
		custRepo.save(c1);
		custRepo.save(c2);
		custRepo.save(c3);

		List<Customer> customers=custRepo.findAll();
//		loop thru all custs
		for(Customer c:customers){
			System.out.println(c.toString());
		}
	}
}
