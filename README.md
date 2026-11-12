# Task24-Build-a-CSV-Employee-Data-Processor
java calculation

## Project Description
The CSV Employee Data Processor is a Java application that reads employee records from a CSV file, validates the data, calculates employee statistics, and generates a processed output CSV file.

The program identifies invalid records such as missing fields and incorrect salary values. It skips invalid records without stopping the entire program.

## Objectives
- Read employee details from a CSV file.
- Validate employee records.
- Identify missing and invalid fields.
- Handle malformed records using exception handling.
- Calculate employee salary statistics.
- Generate a processed output CSV file.

## Technologies Used
- Java
- CSV (Comma-Separated Values)
- File I/O
- BufferedReader
- FileWriter
- PrintWriter
- ArrayList
- Exception Handling

## Project Files

```text
Task24/
│
├── Task24.java
├── employees.csv
└── processed_employees.csv
```

## Input CSV Format

The input file (`employees.csv`) contains the following columns:

| ID | Name | Department | Salary |
|---|---|---|---|
| 101 | Ravi | IT | 45000 |
| 102 | Sita | HR | 35000 |
| 103 | John | Finance | 50000 |
| 104 | Anu | IT | 40000 |
| 105 | Rahul | Sales | 30000 |
| 106 | Empty | IT | 25000 |
| 107 | Kiran | HR | abc |
| 108 | Meena | Finance | 55000 |

## Features

1. **CSV Reading:** Reads employee records from the input CSV file.
2. **Data Validation:** Checks employee ID, name, department, and salary.
3. **Error Handling:** Handles invalid records without stopping execution.
4. **Statistics Calculation:** Calculates total salary, average salary, highest salary, and lowest salary.
5. **Output Generation:** Creates a new CSV file containing only valid employee records.

## Sample Output

```text
Invalid record: 106,,IT,25000
Invalid record: 107,Kiran,HR,abc

Output CSV generated successfully.

----- Employee Statistics -----
Valid Employees: 6
Invalid Records: 2
Total Salary: 255000.0
Average Salary: 42500.0
Highest Salary: 55000.0
Lowest Salary: 30000.0
```

## How to Run the Program

**Step 1:** Install Java JDK.

**Step 2:** Save the Java source code as `Task24.java`.

**Step 3:** Create `employees.csv` in the same folder.

**Step 4:** Open Command Prompt in the project folder.

**Step 5:** Compile the program:

```bash
javac Task24.java
```

**Step 6:** Run the program:

```bash
java Task24
```

**Step 7:** Check the generated `processed_employees.csv` file.

## Learning Outcomes

- Learned how to read and write CSV files in Java.
- Understood file handling concepts.
- Practiced data validation techniques.
- Improved exception-handling skills.
- Learned to calculate statistics from employee records.
- Understood how to handle invalid data safely.
