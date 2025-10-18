package customer_product;

import java.time.LocalDate;
import database.CustomerProductDatabase;
import java.util.ArrayList;


public class testCustomer {
    public static void main(String[] args) {
    
        
        ArrayList<CustomerProduct> csproducts;

        CustomerProductDatabase db = new CustomerProductDatabase("customer_product/CustomerProduct.txt");
        db.readFromFile();
        csproducts = db.returnAllRecords();
        System.out.println(db.contains("4151512231"));
        for(int i=0 ; i< csproducts.size(); i++)
        {
            CustomerProduct tmp = csproducts.get(i);

            System.out.println(tmp.lineRepresentation());

        }
        CustomerProduct tmp = new CustomerProduct("123456789", "P8552", LocalDate.now());

        System.out.println(tmp.lineRepresentation());

        db.insertRecord(tmp);
        db.saveToFile();
        
        
        db.readFromFile();
        csproducts = db.returnAllRecords();
        System.out.println(db.contains("4151512231"));
        for(int i=0 ; i< csproducts.size(); i++)
        {
             tmp = csproducts.get(i);

            System.out.println(tmp.lineRepresentation());
        }

        System.out.println(tmp.getSearchKey());
   }
}
