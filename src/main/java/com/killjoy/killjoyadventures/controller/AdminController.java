  package com.killjoy.killjoyadventures.controller;

  import com.killjoy.killjoyadventures.exception.ResourceNotFoundException;
  import com.killjoy.killjoyadventures.model.Activity;
  import com.killjoy.killjoyadventures.model.Employee;
  import com.killjoy.killjoyadventures.service.ActivityService;
  import com.killjoy.killjoyadventures.service.EmployeeService;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.HttpStatus;
  import org.springframework.http.ResponseEntity;
  import org.springframework.web.bind.annotation.*;

  import java.util.List;
  import java.util.Optional;


  @CrossOrigin(origins = "*")
  @RestController
  @RequestMapping("/admin")
  public class AdminController {
    @Autowired
    private final ActivityService activityService;
    @Autowired
    private final EmployeeService employeeService;

    public AdminController(ActivityService activityService, EmployeeService employeeService) {
      this.activityService = activityService;
      this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String index(){
      return ("/");
    }
    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
      System.out.println(activityService.getAll());
      return activityService.getAll();
    }

    @GetMapping("/activity/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Integer id) {
      Optional<Activity> optionalActivity = Optional.ofNullable(activityService.getActivityById(id));
      if (optionalActivity.isPresent()) {
        Activity activity = optionalActivity.get();
        return ResponseEntity.ok(activity);
      } else {
        throw new ResourceNotFoundException("Activity", id);
        // or return ResponseEntity.notFound().build();
      }
    }

    @PostMapping("/activity")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
      Activity savedActivity = activityService.createActivity(activity);
      System.out.println(savedActivity);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedActivity);
    }

    @PutMapping("/activity/{id}")
    public ResponseEntity<Activity> updateActivityById(@PathVariable Integer id, @RequestBody Activity activityRequest) {
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

    @DeleteMapping("/activity/{id}")
    public ResponseEntity<Void> deleteActivityById(@PathVariable Integer id) {
      activityService.deleteActivity(id);
      return ResponseEntity.noContent().build();
    }

    // Employee APIs
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
      return employeeService.getAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
      Employee employee = employeeService.getEmployeeById(id);
      if (employee == null) {
        throw new ResourceNotFoundException("Employee", id);
      }
      return ResponseEntity.ok(employee);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
      Employee savedEmployee = employeeService.createEmployee(employee);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Integer id, @RequestBody Employee employeeRequest) {
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

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Integer id) {
      employeeService.deleteEmployee(id);
      return ResponseEntity.noContent().build();
    }
  }
