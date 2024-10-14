import java.util.*;
import java.io.*;

public class Main {

    public static Map<String, Integer> processData(ArrayList<String> array) {
        // Create a Map to store department and highest salary employee ID
        Map<String, Integer> highestPaidInDept = new HashMap<>();
        // Create a Map to track the highest salary in each department
        Map<String, Integer> highestSalaryInDept = new HashMap<>();

        for (String line : array) {
            // Check if the line is not empty
            if (line.trim().isEmpty()) {
                continue; // Skip empty lines
            }

            // Split the input line into fields
            String[] fields = line.split(", ");

            // Check if the line has exactly 4 fields (ID, Name, Department, Salary)
            if (fields.length != 4) {
                System.out.println("Invalid line format: " + line);
                continue; // Skip lines that don't have the correct format
            }

            try {
                int employeeID = Integer.parseInt(fields[0]); // Employee ID
                String department = fields[2]; // Department
                int salary = Integer.parseInt(fields[3]); // Salary

                // If department is not yet in the map, or if the current employee has a higher salary
                if (!highestSalaryInDept.containsKey(department) || salary > highestSalaryInDept.get(department)) {
                    // Update the maps with the new highest salary and corresponding employee ID
                    highestSalaryInDept.put(department, salary);
                    highestPaidInDept.put(department, employeeID);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing number in line: " + line);
            }
        }

        return highestPaidInDept; // Return the result map
    }

    public static void main(String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while (in.hasNextLine())
                inputData.add(in.nextLine());
            Map<String, Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for (Map.Entry<String, Integer> e : retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
        }
    }
}
