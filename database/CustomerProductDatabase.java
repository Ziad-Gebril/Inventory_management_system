package database;


import java.time.LocalDate;
import java.time.format.*;

import customer_product.CustomerProduct;

public class CustomerProductDatabase extends Database<CustomerProduct> {
   
    //database constructor for customer products
public CustomerProductDatabase(String filename) {
       super(filename);
    }

//****************************************** methods **************************************** */

    @Override
    public CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        return new CustomerProduct(parts[0], parts[1], LocalDate.parse(parts[2],formatter));
    }


}
