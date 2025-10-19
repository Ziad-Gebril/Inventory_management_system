import java.time.LocalDate;
import java.time.format.*;
import java.util.*;
import utils.Generator;
import utils.Validator;
import java.lang.InterruptedException;
import java.io.IOException;
import database.*;
import customer_product.*;

public class MainMenu {

    final String RESET = "\u001B[0m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String BLUE = "\u001B[34m";
    final String PURPLE = "\u001B[35m";
    final String CYAN = "\u001B[36m";
    final String WHITE = "\u001B[37m";
    
   
    
    public void LoginMenu() {
        System.out.println(BLUE + "================= Inventory Management System =================" + RESET);
        System.out.println(GREEN + "1. Admin Login" + RESET);
        System.out.println(GREEN + "2. Employee Login" + RESET);
        System.out.println(GREEN + "3. Exit" + RESET);
        System.out.println(BLUE + "==============================================================" + RESET);
        System.out.print(YELLOW + "Please select an option (1 --> 3): " + RESET);

         
    Scanner scan = new Scanner(System.in);
    int choice = scan.nextInt();

        switch(choice)
        {
            case 1:
            System.out.println("under construction...");            

            case 2:
            System.out.println("under construction...");

            case 3:
            System.out.println("under construction...");
            System.exit(0);

            default :
            System.out.println(RED + "Invalid Choice! Please try again." + RESET);
            LoginMenu();
        }
    }

    





    //**************************************Helping Functions***********************************//

    public String getDateFormated(LocalDate Date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = Date.format(formatter);
        return date;
    }

    public LocalDate getLocalDateFormated(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate Date = LocalDate.parse(date,formatter);
        return Date;
    }

    static void clearScreen() {
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
