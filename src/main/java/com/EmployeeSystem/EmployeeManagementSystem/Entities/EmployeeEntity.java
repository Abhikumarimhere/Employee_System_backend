package com.EmployeeSystem.EmployeeManagementSystem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeID;
    private String firstName;
    private String lastName;
    private String emailId;
}
