package customer_product;

import java.time.LocalDate;
import database.CustomerProductDatabase;
import java.util.ArrayList;


public class testCustomer {
    public static void main(String[] args) {
    
        
        ArrayList<CustomerProduct> csproducts;

        //E:\\OneDrive\\Desktop\\Programing\\Cursor\\Labs\\Lab4\\inventory\\Inventory_management_system\\customer_product\\CustomerProduct.txt
        //customer_product/CustomerProduct.txt
        CustomerProductDatabase db = new CustomerProductDatabase("customer_product/CustomerProduct.txt");
        db.readFromFile();
        csproducts = db.returnAllRecords();
        

        for(int i=0 ; i< csproducts.size(); i++)
        {
            CustomerProduct tmp = csproducts.get(i);

            System.out.println(tmp.lineRepresentation());

        }
        System.out.println();
        
        CustomerProduct tmp = new CustomerProduct("123456789", "P8552", LocalDate.now());

        System.out.println(tmp.lineRepresentation());
        System.out.println();

        db.insertRecord(tmp);
        db.saveToFile();
        
        
        db.readFromFile();
        csproducts = db.returnAllRecords();
        for(int i=0 ; i< csproducts.size(); i++)
        {
             tmp = csproducts.get(i);

            System.out.println(tmp.lineRepresentation());
        }


        System.out.println(db.contains("123456789,P8552,18-10-2025"));
   }
}
