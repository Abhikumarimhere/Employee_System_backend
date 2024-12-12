package com.EmployeeSystem.EmployeeManagementSystem.Services;

import com.EmployeeSystem.EmployeeManagementSystem.Exceptions.EmployeeNotFoundException;
import com.EmployeeSystem.EmployeeManagementSystem.Model.Employee;

import java.util.List;

public interface EmployeeService {
  public Employee createEmployee(Employee employee);

  List<Employee> fetchAll();

  boolean deleteEmployeebyID(Long empID)throws EmployeeNotFoundException;

  Employee getEmployeeById(long id)throws EmployeeNotFoundException;

  Employee updateById(Long id, Employee employee)throws EmployeeNotFoundException;
}
