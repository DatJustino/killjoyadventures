package com.killjoy.killjoyadventures.controller;

import com.killjoy.killjoyadventures.model.Customer;
import com.killjoy.killjoyadventures.service.CustomerService;
import com.killjoy.killjoyadventures.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
    Customer customer = customerService.getCustomerById(id);
    return new ResponseEntity<>(customer, HttpStatus.OK);
  }

  @PostMapping("createcustomer")
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    Customer createdCustomer = customerService.createCustomer(customer);
    return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
  }

  @PutMapping("/customer/{id}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
    Customer updatedCustomer = customerService.updateCustomer(id, customer);
    return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
  }

  @DeleteMapping("/customer/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
    customerService.deleteCustomer(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
