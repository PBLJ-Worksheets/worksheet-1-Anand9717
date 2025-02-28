import java.util.Scanner;

public class NewEmployeeSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        String employeeID = input.nextLine();

        String[][] employees = {
            {"3001", "Arjun", "01/05/2015", "e", "Research", "28000", "10000", "4000"},
            {"3002", "Priya", "15/10/2017", "c", "Project Management", "36000", "14000", "10000"},
            {"3003", "Vikram", "22/11/2012", "k", "Accounts", "16000", "9000", "1500"},
            {"3004", "Ananya", "03/04/2018", "r", "Front Desk", "15000", "7000", "2500"},
            {"3005", "Karan", "09/08/2010", "m", "Engineering", "57000", "23000", "22000"},
            {"3006", "Sana", "18/03/2005", "e", "Manufacturing", "29000", "10500", "5000"},
            {"3007", "Ishaan", "12/07/2008", "c", "Project Management", "34000", "13000", "11000"}
        };

        String[] employee = findEmployeeById(employees, employeeID);
        if (employee == null) {
            System.out.println("Employee with Employee ID " + employeeID + " not found.");
            return;
        }

        String designation = getDesignation(employee[3]);
        int da = getDA(employee[3]);
        int basicSalary = Integer.parseInt(employee[5]);
        int hra = Integer.parseInt(employee[6]);
        int it = Integer.parseInt(employee[7]);
        int totalSalary = basicSalary + hra + da - it;

        System.out.printf("Employee Name: %s%nDepartment: %s%nDesignation: %s%n", employee[1], employee[4], designation);
        System.out.printf("Basic Salary: %s%nDA: %d%nHRA: %s%nIT: %s%nTotal Salary: %d%n", employee[5], da, employee[6], employee[7], totalSalary);
    }

    private static String[] findEmployeeById(String[][] employees, String id) {
        for (String[] employee : employees) {
            if (employee[0].equals(id)) {
                return employee;
            }
        }
        return null;
    }

    private static String getDesignation(String code) {
        switch (code) {
            case "e": return "Engineer";
            case "c": return "Consultant";
            case "k": return "Clerk";
            case "r": return "Receptionist";
            case "m": return "Manager";
            default: return "Unknown";
        }
    }

    private static int getDA(String code) {
        switch (code) {
            case "e": return 21000;
            case "c": return 33000;
            case "k": return 13000;
            case "r": return 16000;
            case "m": return 42000;
            default: return 0;
        }
    }
}
