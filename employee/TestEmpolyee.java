package employee;
import database.EmployeeUserDatabase;

public class TestEmpolyee {
     public static void main(String[] args) {
        EmployeeUserDatabase db = new EmployeeUserDatabase("employee/employees.txt");

        db.readFromFile();

        System.out.println("Current employees loaded from file:");
        for (EmployeeUser e : db.returnAllRecords()) {
            System.out.println(e.lineRepresentation());
        }


       EmployeeUser newEmp = new EmployeeUser("E10", "f", "nour@example.com", "Mansoura", "01000000045");
       db.insertRecord(newEmp); 
       db.saveToFile();

        System.out.println("\nAfter adding Nour and saving:");
        for (EmployeeUser e : db.returnAllRecords()) {
            System.out.println(e.lineRepresentation());
        }
        db.deleteRecord("E2");
        db.saveToFile();
        for (EmployeeUser e : db.returnAllRecords()) {
            System.out.println(e.lineRepresentation());
        }
    }
}
