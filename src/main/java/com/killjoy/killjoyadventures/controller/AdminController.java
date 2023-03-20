package com.killjoy.killjoyadventures.controller;

import com.killjoy.killjoyadventures.exception.ResourceNotFoundException;
import com.killjoy.killjoyadventures.model.Activity;
import com.killjoy.killjoyadventures.model.Employee;
import com.killjoy.killjoyadventures.service.ActivityService;
import com.killjoy.killjoyadventures.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

  private final ActivityService activityService;
  private final EmployeeService employeeService;

  public AdminController(ActivityService activityService, EmployeeService employeeService) {
    this.activityService = activityService;
    this.employeeService = employeeService;
  }

  // Activity APIs
  @GetMapping("/activities")
  public List<Activity> getAllActivities() {
    return activityService.getAll();
  }

  @GetMapping("/activities/{id}")
  public ResponseEntity<Activity> getActivityById(@PathVariable String id) {
    Optional<Activity> optionalActivity = Optional.ofNullable(activityService.getActivityById(id));
    if (optionalActivity.isPresent()) {
      Activity activity = optionalActivity.get();
      return ResponseEntity.ok(activity);
    } else {
      throw new ResourceNotFoundException("Activity", id);
      // or return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/activities")
  public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
    Activity savedActivity = activityService.createActivity(activity);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedActivity);
  }

  @PutMapping("/activities/{id}")
  public ResponseEntity<Activity> updateActivityById(@PathVariable String id, @RequestBody Activity activityRequest) {
    Activity activity = activityService.getActivityById(id);
    if (activity == null) {
      throw new ResourceNotFoundException("Activity", id);
    }
    activity.setActivityName(activityRequest.getActivityName());
 /*   activity.setDescription(activityRequest.getDescription());
    activity.setImageUrl(activityRequest.getImageUrl());
    activity.setPrice(activityRequest.getPrice());
*/
    Activity updatedActivity = activityService.updateActivity(id, activity);
    return ResponseEntity.ok(updatedActivity);
  }

  @DeleteMapping("/activities/{id}")
  public ResponseEntity<Void> deleteActivityById(@PathVariable String id) {
    activityService.deleteActivity(id);
    return ResponseEntity.noContent().build();
  }

  // Employee APIs
  @GetMapping("/employees")
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployee();
  }

  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
    Employee employee = employeeService.getEmployeeById(id);
    if (employee == null) {
      throw new ResourceNotFoundException("Employee", id);
    }
    return ResponseEntity.ok(employee);
  }

  @PostMapping("/employees")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
    Employee savedEmployee = employeeService.createEmployee(employee);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
  }

  @PutMapping("/employees/{id}")
  public ResponseEntity<Employee> updateEmployeeById(@PathVariable String id, @RequestBody Employee employeeRequest) {
    Employee employee = employeeService.getEmployeeById(id);
    if (employee == null) {
      throw new ResourceNotFoundException("employee", id);
    } else {
      employee.setName(employeeRequest.getName());
      employee.setEmail(employeeRequest.getEmail());

      Employee updatedEmployee = employeeService.updateEmployee(id, employee);
      return ResponseEntity.ok(updatedEmployee);
    }
  }

  @DeleteMapping("/employees/{id}")
  public ResponseEntity<Void> deleteEmployeeById(@PathVariable String id) {
    employeeService.deleteEmployee(id);
    return ResponseEntity.noContent().build();
  }
}
