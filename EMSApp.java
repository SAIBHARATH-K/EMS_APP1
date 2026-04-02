package com.ibm.ems;

import java.util.Scanner;

public class EMSApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        try {
            FileUtil.load(service);
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }

        while (true) {
            System.out.println("\n===== EMS MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Process Salary");
            System.out.println("7. Save Data");
            System.out.println("8. Exit");

            int choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.println("Enter ID, Name, Salary, Type(P/C):");
                        int id = sc.nextInt();
                        String name = sc.next();
                        double salary = sc.nextDouble();
                        String type = sc.next();

                        if (type.equalsIgnoreCase("P"))
                            service.addEmployee(new PermanentEmployee(id, name, salary));
                        else
                            service.addEmployee(new ContractEmployee(id, name, salary));
                        break;

                    case 2:
                        service.viewEmployees();
                        break;

                    case 3:
                        System.out.println("Enter ID to update:");
                        int uid = sc.nextInt();
                        System.out.println("Enter new Name & Salary:");
                        String uname = sc.next();
                        double usal = sc.nextDouble();
                        service.updateEmployee(uid, uname, usal);
                        break;

                    case 4:
                        System.out.println("Enter ID to delete:");
                        service.deleteEmployee(sc.nextInt());
                        break;

                    case 5:
                        System.out.println("Enter ID to search:");
                        System.out.println(service.findById(sc.nextInt()));
                        break;

                    case 6:
                        for (Employee e : service.getAll()) {
                            new Thread(new SalaryTask(e)).start();
                        }
                        break;

                    case 7:
                        FileUtil.save(service);
                        System.out.println("Data saved.");
                        break;

                    case 8:
                        FileUtil.save(service);
                        System.out.println("Exiting...");
                        System.exit(0);
                }

            } catch (EmployeeNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        
        }
    }
}