package utils;
import java.time.LocalDate;
import java.time.format.*;
import java.util.*;
import java.lang.InterruptedException;
import java.io.IOException;
import database.*;
import customer_product.*;
import employee.*;
import Admin.AdminRole;
import utils.Validator;
import utils.Generator;
import java.util.ArrayList;

public class MainMenuFunctions {




    public static void AddEmployee(AdminRole admin)
    {
        Scanner scan = new Scanner(System.in);
        
        String ID = Generator.generateEmployeeRandomId();

        System.out.print("Enter the Employee's Name: ");
        String Name = scan.nextLine();

        System.out.print("Enter the Employee's Email: ");
        String email = scan.nextLine();
        Validator.isValidEmail(email);

        System.out.print("Enter the Employee's address: ");
        String address = scan.nextLine();
       
        System.out.print("Enter the Employee's Phone Number: ");
        String Phone = scan.nextLine();
        Validator.isValidPhoneNumber(Phone);

        admin.addEmployee(ID , Name, email, address, Phone );
    }


    public static void ShowAllEmployees(AdminRole admin)
    {
        EmployeeUser[] list = admin.getListOfEmployees();

        for(int i=0 ; i< list.length ; i++)
       {
        System.out.println(list[i].lineRepresentation());
       }
        
    }

    





    public static String getDateFormated(LocalDate Date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = Date.format(formatter);
        return date;
    }

    public static LocalDate getLocalDateFormated(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate Date = LocalDate.parse(date,formatter);
        return Date;
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
