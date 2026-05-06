package com.ibm.ems;

import java.util.Objects;

public class Employee {

    protected int id;
    protected String name;
    protected double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Business method
    public double calculateSalary() {
        return salary;
    }

    // Getters
    public int getId() { 
        return id; 
    }

    public String getName() { 
        return name; 
    }

    public double getSalary() { 
        return salary; 
    }

    // Setters
    public void setName(String name) { 
        this.name = name; 
    }

    public void setSalary(double salary) { 
        this.salary = salary; 
    }

    // toString
    @Override
    public String toString() {
        return id + " | " + name + " | " + salary;
    }

    // ✅ equals() method (based on ID)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Employee other = (Employee) obj;

        return this.id == other.id;
    }

    // ✅ hashCode() method (based on ID)
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}