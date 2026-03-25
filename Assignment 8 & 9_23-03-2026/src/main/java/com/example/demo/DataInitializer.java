package com.example.demo;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataInitializer(DepartmentRepository departmentRepository,
                           EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        Department marketing = departmentRepository.save(new Department("Marketing", "Neha Verma"));
        Department operations = departmentRepository.save(new Department("Operations", "Rajesh Mehta"));
        Department support = departmentRepository.save(new Department("Customer Support", "Anita Desai"));

        employeeRepository.save(new Employee("Arjun Malhotra", 58000.0, Set.of("9012345678", "9123456789"), marketing));
        employeeRepository.save(new Employee("Sneha Kapoor", 64000.0, Set.of("9234567890"), marketing));
        employeeRepository.save(new Employee("Karan Bansal", 72000.0, Set.of("9345678901"), operations));
        employeeRepository.save(new Employee("Meera Iyer", 81000.0, Set.of("9456789012", "9567890123"), operations));
        employeeRepository.save(new Employee("Rohit Agarwal", 69000.0, Set.of("9678901234"), support));

        System.out.println(">>> Sample data initialized successfully.");
    }
}