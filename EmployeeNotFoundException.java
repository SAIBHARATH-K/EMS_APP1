package com.ibm.ems;

// Custom exception for handling employee not found cases
public class EmployeeNotFoundException extends Exception {

    // Default constructor
    public EmployeeNotFoundException() {
        super("Employee not found");
    }

    // Constructor with custom message
    public EmployeeNotFoundException(String msg) {
        super(msg);
    }

    // Constructor with message and cause
    public EmployeeNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    // Constructor with cause only
    public EmployeeNotFoundException(Throwable cause) {
        super(cause);
    }

    // Optional: override toString for better readability
    @Override
    public String toString() {
        return "EmployeeNotFoundException: " + getMessage();
    }
}
