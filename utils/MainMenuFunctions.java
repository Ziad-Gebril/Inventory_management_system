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

public class MainMenuFunctions {




    public static void AddEmployee(AdminRole admin)
    {
        Scanner scan = new Scanner(System.in);
        
        String ID = generateEmployeeRandomId();

        System.out.print("Enter the Employee's Name: ");
        String Name = scan.nextLine();

        System.out.print("Enter the Employee's Email: ");
        String email = scan.nextLine();
        isValidEmail(email);

        System.out.print("Enter the Employee's address: ");
        String address = scan.nextLine();
       
        System.out.print("Enter the Employee's Phone Number: ");
        String Phone = scan.nextLine();
        isValidPhoneNumber(Phone);

        admin.addEmployee(ID , Name, email, address, );
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
