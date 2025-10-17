package employee;
import database.EmployeeUserDatabase;

public class TestEmpolyee {
     public static void main(String[] args) {
        EmployeeUserDatabase db = new EmployeeUserDatabase("E:\\OneDrive\\Desktop\\Programing\\Cursor\\Labs\\Lab4\\inventory\\Inventory_management_system\\employee\\employees.txt");

        db.readFromFile();

        System.out.println("Current employees loaded from file:");
        for (EmployeeUser e : db.returnAllRecords()) {
            System.out.println(e.lineRepresentation());
        }

        EmployeeUser newEmp = new EmployeeUser("Nour", "nour@example.com", "Mansoura", "0100000004");
        db.insertRecord(newEmp);

        db.saveToFile();

        System.out.println("\nAfter adding Nour and saving:");
        for (EmployeeUser e : db.returnAllRecords()) {
            System.out.println(e.lineRepresentation());
        }
    }
}
