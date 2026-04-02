package com.ibm.ems;

import java.io.*;

public class FileUtil {

    // Save all employees to file
    public static void save(EmployeeService service) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees.txt"));

        for (Employee e : service.getAll()) {
            String type = (e instanceof PermanentEmployee) ? "P" : "C";
            bw.write(e.getId() + "," + e.getName() + "," + e.getSalary() + "," + type);
            bw.newLine();
        }

        bw.close();
    }

    // Load all employees from file
    public static void load(EmployeeService service) throws IOException {
        File file = new File("employees.txt");

        if (!file.exists()) return; // No file yet

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            int id = Integer.parseInt(data[0]);
            String name = data[1];
            double salary = Double.parseDouble(data[2]);
            String type = data[3];

            if (type.equalsIgnoreCase("P")) {
                service.addEmployee(new PermanentEmployee(id, name, salary));
            } else {
                service.addEmployee(new ContractEmployee(id, name, salary));
            }
        }

        br.close();
    }
}