package com.ibm.ems;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}