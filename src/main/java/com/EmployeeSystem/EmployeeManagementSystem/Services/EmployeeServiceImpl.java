package com.EmployeeSystem.EmployeeManagementSystem.Services;

import com.EmployeeSystem.EmployeeManagementSystem.Entities.EmployeeEntity;
import com.EmployeeSystem.EmployeeManagementSystem.Exceptions.EmployeeNotFoundException;
import com.EmployeeSystem.EmployeeManagementSystem.Model.Employee;
import com.EmployeeSystem.EmployeeManagementSystem.Repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
         employeeRepository.save(employeeEntity);
         return employee;
    }

    @Override
    public List<Employee> fetchAll() {
        List<EmployeeEntity> list=employeeRepository.findAll();
        List<Employee> employees=list.
                stream().
                map(emp -> new Employee(
                        emp.getEmployeeID(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());

                return employees;
    }

    @Override
    public boolean deleteEmployeebyID(Long empID) throws EmployeeNotFoundException {
        Optional<EmployeeEntity> empl=employeeRepository.findById(empID);
        if(!empl.isPresent()){
            throw new EmployeeNotFoundException("Employee not found");
        }
        employeeRepository.delete(empl.get());
        return true;
    }

    @Override
    public Employee getEmployeeById(long id) throws EmployeeNotFoundException {
        Optional<EmployeeEntity> employee=employeeRepository.findById(id);
        if(!employee.isPresent()){
            throw new EmployeeNotFoundException("Employee Not Found");
        }
        Employee employee1=new Employee();
        BeanUtils.copyProperties(employee.get(),employee1);
        return employee1;
    }

    @Override
    public Employee updateById(Long id, Employee employee) throws EmployeeNotFoundException{
       Optional<EmployeeEntity> empl=employeeRepository.findById(id);
       if(!empl.isPresent()){
           throw  new EmployeeNotFoundException("Employee Does Not Exist");
       }
        empl.get().setEmailId(employee.getEmailId());
        empl.get().setFirstName(employee.getFirstName());
        empl.get().setLastName(employee.getLastName());
        employeeRepository.save(empl.get());
        return employee;
    }
}
