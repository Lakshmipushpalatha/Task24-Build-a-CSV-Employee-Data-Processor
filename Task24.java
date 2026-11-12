import java.io.*;
import java.util.*;

public class Task24 {

    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name,
                 String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {

        String inputFile = "employees.csv";
        String outputFile = "processed_employees.csv";

        ArrayList<Employee> employees = new ArrayList<>();

        int validCount = 0;
        int invalidCount = 0;
        double totalSalary = 0;
        double highestSalary = Double.MIN_VALUE;
        double lowestSalary = Double.MAX_VALUE;

        try (BufferedReader br =
             new BufferedReader(new FileReader(inputFile))) {

            String line;
            boolean header = true;

            while ((line = br.readLine()) != null) {

                if (header) {
                    header = false;
                    continue;
                }

                try {
                    String[] data = line.split(",", -1);

                    if (data.length != 4) {
                        throw new Exception("Incorrect number of fields");
                    }

                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    String department = data[2].trim();
                    double salary =
                        Double.parseDouble(data[3].trim());

                    if (id <= 0 || name.isEmpty()
                            || department.isEmpty()) {
                        throw new Exception("Missing or invalid fields");
                    }

                    if (!Double.isFinite(salary) || salary < 0) {
                        throw new Exception("Invalid salary");
                    }

                    Employee emp = new Employee(
                        id, name, department, salary
                    );

                    employees.add(emp);

                    totalSalary += salary;

                    if (salary > highestSalary) {
                        highestSalary = salary;
                    }

                    if (salary < lowestSalary) {
                        lowestSalary = salary;
                    }

                    validCount++;

                } catch (Exception e) {
                    invalidCount++;
                    System.out.println(
                        "Invalid record: " + line +
                        " | Reason: " + e.getMessage()
                    );
                }
            }

        } catch (IOException e) {
            System.out.println(
                "Error reading file: " + e.getMessage()
            );
            return;
        }

        try (PrintWriter pw =
             new PrintWriter(new FileWriter(outputFile))) {

            pw.println("ID,Name,Department,Salary");

            for (Employee emp : employees) {
                pw.println(
                    emp.id + "," +
                    emp.name + "," +
                    emp.department + "," +
                    emp.salary
                );
            }

            System.out.println("\nOutput CSV generated successfully.");

        } catch (IOException e) {
            System.out.println(
                "Error writing file: " + e.getMessage()
            );
        }

        System.out.println("\n----- Employee Statistics -----");

        System.out.println("Valid Employees: " + validCount);
        System.out.println("Invalid Records: " + invalidCount);

        if (validCount > 0) {
            System.out.println("Total Salary: " + totalSalary);
            System.out.println(
                "Average Salary: " + (totalSalary / validCount)
            );
            System.out.println("Highest Salary: " + highestSalary);
            System.out.println("Lowest Salary: " + lowestSalary);
        } else {
            System.out.println("No valid employee records found.");
        }
    }
}
