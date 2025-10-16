package employee;
import database.EmployeeUserDatabase;

public class TestEmpolyee {
     public static void main(String[] args) {
        String fileName = "employee/employees.txt";
        EmployeeUserDatabase db = new EmployeeUserDatabase(fileName);

        db.readFromFile();

        EmployeeUser e1 = new EmployeeUser("Ali", "ali@example.com", "Cairo", "0100000001");
        EmployeeUser e2 = new EmployeeUser("Sara", "sara@example.com", "Alex", "0100000002");
        EmployeeUser e3 = new EmployeeUser("Omar", "omar@example.com", "Giza", "0100000003");

        db.insertRecord(e1);
        db.insertRecord(e2);
        db.insertRecord(e3);

        db.saveToFile();

        System.out.println(" Current employees in memory:");
        for (EmployeeUser emp : db.returnAllRecords()) {
            System.out.println(emp.lineRepresentation());
        }

        EmployeeUserDatabase db2 = new EmployeeUserDatabase(fileName);
        db2.readFromFile();

        System.out.println("\n Employees loaded from file:");
        for (EmployeeUser emp : db2.returnAllRecords()) {
            System.out.println(emp.lineRepresentation());
        }

        EmployeeUser e4 = new EmployeeUser("Nour", "nour@example.com", "Masr", "0100000004");
        db2.insertRecord(e4);
        db2.saveToFile();

        System.out.println("\n After adding Nour and saving again:");
        for (EmployeeUser emp : db2.returnAllRecords()) {
            System.out.println(emp.lineRepresentation());
        }
    }

}
