import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConsecutiveDaysWorked {

    public static void main(String[] args) {
        String filename = "employee_records.txt"; // Replace with your input file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String currentEmployee = null;
            int consecutiveDays = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String employeeName = parts[0];
                String position = parts[1];
                int daysWorked = Integer.parseInt(parts[2]);

                if (employeeName.equals(currentEmployee) && daysWorked == 1) {
                    consecutiveDays++;
                } else {
                    consecutiveDays = 1; // Reset consecutive days if not the same employee or not 1 day worked
                }

                if (consecutiveDays == 7) {
                    System.out.println("Employee: " + currentEmployee + ", Position: " + position);
                }

                currentEmployee = employeeName;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
