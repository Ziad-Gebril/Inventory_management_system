package Admin;

import database.EmployeeUserDatabase;
import employee.EmployeeUser;
import java.util.ArrayList;


class AdminRole {
    final String RESET = "\u001B[0m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";

    private EmployeeUserDatabase database;
    

    public AdminRole() {

        //E:\\OneDrive\\Desktop\\Programing\\Cursor\\Labs\\Lab4\\inventory\\Inventory_management_system\\employee\\employees.txt
        this.database = new EmployeeUserDatabase("E:\\OneDrive\\Desktop\\Programing\\Cursor\\Labs\\Lab4\\inventory\\Inventory_management_system\\employee\\employees.txt");
        this.database.readFromFile();
    }

    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        if (!database.contains(employeeId)) {
            EmployeeUser emp = new EmployeeUser(employeeId, name, email, address, phoneNumber);
            database.insertRecord(emp);
        }
    }

    public EmployeeUser[] getListOfEmployees() {
        ArrayList<EmployeeUser> list = database.returnAllRecords();
        return list.toArray(new EmployeeUser[0]);
    }

    public void removeEmployee(String key) {
        if (database.contains(key)) {
            database.deleteRecord(key);
            System.out.println(GREEN + "Employee with ID: " + key +" Was Deleted Successfully..."+ RESET);
        }
        else
        {
            System.out.println(RED + "No Emplyee with this ID is Listed........." + RESET);
        }
    }

    public void logout() {
        database.saveToFile();
    }

}