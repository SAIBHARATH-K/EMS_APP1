package com.ibm.ems;

public class PermanentEmployee extends Employee {

    private double bonus;
    private double taxRate = 0.05; // 5% tax

    public PermanentEmployee(int id, String name, double salary, double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        double grossSalary = salary + (salary * 0.10) + bonus;
        double tax = grossSalary * taxRate;
        return grossSalary - tax;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void displayDetails() {
        System.out.println("Permanent Employee Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + salary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Net Salary: " + calculateSalary());
    }
}
