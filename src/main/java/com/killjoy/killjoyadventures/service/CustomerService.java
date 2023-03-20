package com.killjoy.killjoyadventures.service;

import com.killjoy.killjoyadventures.exception.ResourceNotFoundException;
import com.killjoy.killjoyadventures.model.Customer;
import com.killjoy.killjoyadventures.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
  @Autowired
  private final CustomerRepo customerRepo;

  public CustomerService(CustomerRepo customerRepo) {
    this.customerRepo = customerRepo;
  }

  public List<Customer> getAllCustomers() {
    return customerRepo.findAll();
  }

  public Customer getCustomerById(String id) {
    return customerRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Customer", id));
  }

  public Customer createCustomer(Customer customer) {
    return customerRepo.save(customer);
  }

  //TODO: Needs better paramenter and form in html
  public Customer updateCustomer(String id, Customer customer) {
    Customer existingCustomer = customerRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Customer", id));
    existingCustomer.setCustomerName(customer.getCustomerName());
    existingCustomer.setCustomerEmail(customer.getCustomerEmail());
    return customerRepo.save(existingCustomer);
  }

  public void deleteCustomer(String id) {
    customerRepo.deleteById(id);
  }
}