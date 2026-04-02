package com.ibm.ems;

public class SalaryTask implements Runnable {

    private Employee emp;

    public SalaryTask(Employee emp) {
        this.emp = emp;
    }

    @Override
    public void run() {
        double finalSalary = emp.calculateSalary();
        System.out.println(
            Thread.currentThread().getName() + " -> " +
            emp.getName() + " Final Salary: " + finalSalary
        );
    }
}