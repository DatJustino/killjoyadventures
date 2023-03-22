package com.killjoy.killjoyadventures.service;

import com.killjoy.killjoyadventures.exception.ResourceNotFoundException;
import com.killjoy.killjoyadventures.model.Customer;
import com.killjoy.killjoyadventures.repository.CustomerRepo;
import org.mindrot.jbcrypt.BCrypt;
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

  public Customer getCustomerById(Integer id) {
    return customerRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Customer", id));
  }

  public Customer createCustomer(Customer customer) {
    String hashedPassword = hashPassword(customer.getPassword());
    customer.setPassword(hashedPassword);
    return customerRepo.save(customer);
  }

  private String hashPassword(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt());
  }

  public boolean checkPassword(String plainPassword, String hashedPassword) {
    return BCrypt.checkpw(plainPassword, hashedPassword);
  }
  public Customer authenticateCustomer(Customer customer) {
    Customer foundCustomer = customerRepo.findByCustomerEmail(customer.getCustomerEmail());
    if (foundCustomer != null && checkPassword(customer.getPassword(), foundCustomer.getPassword())) {
      return foundCustomer;
    } else {
      throw new RuntimeException("Invalid email or password");
    }
  }

  //TODO: Needs better paramenter and form in html
  public Customer updateCustomer(Integer id, Customer customer) {
    Customer existingCustomer = customerRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Customer", id));
    existingCustomer.setCustomerName(customer.getCustomerName());
    existingCustomer.setCustomerEmail(customer.getCustomerEmail());
    return customerRepo.save(existingCustomer);
  }

  public void deleteCustomer(Integer id) {
    customerRepo.deleteById(id);
  }
}