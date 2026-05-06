package com.ibm.ems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    private List<Employee> empList = new ArrayList<>();

    // Add Employee
    public void addEmployee(Employee emp) {
        empList.add(emp);
        System.out.println("Employee added successfully.");
    }

    // View All Employees
    public void viewEmployees() {
        if (empList.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        empList.forEach(System.out::println);
    }

    // Find Employee By ID
    public Employee findById(int id) throws EmployeeNotFoundException {
        return empList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));
    }

    // Update Employee
    public void updateEmployee(int id, String name, double salary) throws EmployeeNotFoundException {
        Employee e = findById(id);
        e.setName(name);
        e.setSalary(salary);
        System.out.println("Employee updated successfully.");
    }

    // Delete Employee
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        Employee e = findById(id);
        empList.remove(e);
        System.out.println("Employee deleted successfully.");
    }

    // Get all employees
    public List<Employee> getAll() {
        return empList;
    }

    // Count total employees
    public int getEmployeeCount() {
        return empList.size();
    }

    // Search employees by name
    public List<Employee> searchByName(String name) {
        return empList.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Get employees with salary greater than a given amount
    public List<Employee> getHighSalaryEmployees(double salary) {
        return empList.stream()
                .filter(e -> e.getSalary() > salary)
                .collect(Collectors.toList());
    }

    // Clear all employees
    public void clearEmployees() {
        empList.clear();
        System.out.println("All employee records cleared.");
    }
}
