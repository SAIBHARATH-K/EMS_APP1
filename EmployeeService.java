package com.ibm.ems;

import java.util.ArrayList;
import java.util.List;

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

    // ✅ THIS IS IMPORTANT — must be public
    public List<Employee> getAll() {
        return empList;
    }
}