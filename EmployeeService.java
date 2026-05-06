package com.ibm.ems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    private List<Employee> empList = new ArrayList<>();

    public void addEmployee(Employee emp) {
        empList.add(emp);
    }

    public void viewEmployees() {
        if (empList.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        empList.forEach(System.out::println);
    }

    public Employee findById(int id) throws EmployeeNotFoundException {
        return empList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found!"));
    }

    public void updateEmployee(int id, String name, double salary) throws EmployeeNotFoundException {
        Employee e = findById(id);
        e.setName(name);
        e.setSalary(salary);
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        Employee e = findById(id);
        empList.remove(e);
    }

    // Get all employees
    public List<Employee> getAll() {
        return empList;
    }

    // 🔹 NEW METHODS ADDED BELOW

    // Count total employees
    public int getEmployeeCount() {
        return empList.size();
    }

    // Find employees by name
    public List<Employee> findByName(String name) {
        return empList.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Get employees with salary above given amount
    public List<Employee> getHighSalaryEmployees(double salary) {
        return empList.stream()
                .filter(e -> e.getSalary() > salary)
                .collect(Collectors.toList());
    }

    // Remove all employees
    public void clearAllEmployees() {
        empList.clear();
        System.out.println("All employees removed.");
    }
}