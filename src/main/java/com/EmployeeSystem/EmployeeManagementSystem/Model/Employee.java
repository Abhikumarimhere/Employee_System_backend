package com.EmployeeSystem.EmployeeManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long employeeID;
    private String firstName;
    private String lastName;
    private String emailId;
}
