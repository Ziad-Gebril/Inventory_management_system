import java.time.LocalDate;
import java.time.format.*;
import java.util.*;
import utils.Generator;
import utils.Validator;
public class MainMenu {

    final String RESET = "\u001B[0m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String YELLOW = "\u001B[33m";
    final String BLUE = "\u001B[34m";
    final String PURPLE = "\u001B[35m";
    final String CYAN = "\u001B[36m";
    final String WHITE = "\u001B[37m";
    
    int choice;
    Scanner scanner = new Scanner(System.in);
    public void showMainMenu() {
        System.out.println(BLUE + "================= Inventory Management System =================" + RESET);
        System.out.println(GREEN + "1. Manage Products" + RESET);
        System.out.println(GREEN + "2. Manage Suppliers" + RESET);
        System.out.println(GREEN + "3. Manage Orders" + RESET);
        System.out.println(GREEN + "4. View Reports" + RESET);
        System.out.println(GREEN + "5. Exit" + RESET);
        System.out.println(BLUE + "==============================================================" + RESET);
        System.out.print(YELLOW + "Please select an option (1-5): " + RESET);
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

}
