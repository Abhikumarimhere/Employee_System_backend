package com.EmployeeSystem.EmployeeManagementSystem.Controller;

import com.EmployeeSystem.EmployeeManagementSystem.Entities.EmployeeEntity;
import com.EmployeeSystem.EmployeeManagementSystem.Exceptions.EmployeeNotFoundException;
import com.EmployeeSystem.EmployeeManagementSystem.Model.Employee;
import com.EmployeeSystem.EmployeeManagementSystem.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping( "/api/v1")
public class EmployeeController{
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> fetchAll(){
        return employeeService.fetchAll();
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployeebyID(@PathVariable("id")Long id)throws EmployeeNotFoundException {
        boolean deleted=false;
        deleted=employeeService.deleteEmployeebyID(id);
        Map<String,Boolean> map=new HashMap<>();
        map.put("Deleted",deleted);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id)throws EmployeeNotFoundException{
        Employee empl=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(empl);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateById(@PathVariable("id") Long id,@RequestBody Employee
                                               employee)throws EmployeeNotFoundException{
        employee=employeeService.updateById(id,employee);
        return ResponseEntity.ok(employee);
    }
}
