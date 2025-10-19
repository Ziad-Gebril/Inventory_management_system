package employee;

import customer_product.CustomerProduct;
import product.Product;
import java.time.LocalDate;
import employee.EmployeeRoles;
import java.time.format.*;
import customer_product.*;

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

         System.out.println(emp.applyPayment("4151512231", LocalDate.parse("12-08-2023",formatter)));
         



         




    }
}