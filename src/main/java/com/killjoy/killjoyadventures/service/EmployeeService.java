package com.killjoy.killjoyadventures.service;

import com.killjoy.killjoyadventures.exception.ResourceNotFoundException;
import com.killjoy.killjoyadventures.model.Employee;
import com.killjoy.killjoyadventures.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
  @Autowired
  private final EmployeeRepo employeeRepo;
  public EmployeeService(EmployeeRepo employeeRepo) {
    this.employeeRepo = employeeRepo;
  }
  public List<Employee> getAllEmployee() {
    return employeeRepo.findAll();
  }
  public Employee getEmployeeById(String id) {
    return employeeRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee", id));
  }
  public Employee createEmployee(Employee employee) {
    return employeeRepo.save(employee);
  }

  //TODO: Needs better paramenter and form in html
  public Employee updateEmployee(String id, Employee employee) {
    Employee existingCustomer = employeeRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Employee", id));
    existingCustomer.setName(employee.getName());
    existingCustomer.setEmail(employee.getEmail());
    return employeeRepo.save(existingCustomer);
  }
  public void deleteEmployee(String id) {
    if (!employeeRepo.existsById(id)) {
      throw new ResourceNotFoundException("Employee", id);
    }
    employeeRepo.deleteById(id);
  }
}