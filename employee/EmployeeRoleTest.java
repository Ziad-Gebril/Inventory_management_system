package employee;

import customer_product.CustomerProduct;
import product.Product;
import java.time.LocalDate;
import employee.EmployeeRoles;
import java.time.format.*;

public class EmployeeRoleTest {
    public static void main(String[] args) {



        EmployeeRoles emp = new EmployeeRoles();
        //emp.addProduct("P111", "iPhone", "Apple", "TechSupplier", 100);

       /* 
        Product[] list = emp.getListOfProducts();
        for(int i=0 ; i< list.length ; i++)
       {
        System.out.println(list[i].lineRepresentation());
       }
         */


       /* 
        CustomerProduct[] list = emp.getListOfPurchasingOperations();
        for(int i=0 ; i< list.length ; i++)
       {
        System.out.println(list[i].lineRepresentation());
       }
         */

         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

         System.out.println(emp.returnProduct("123456789", "P8552", LocalDate.parse("18-10-2025",formatter), LocalDate.now()));




    }
}