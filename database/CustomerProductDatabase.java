package database;


import employee.CustomerProduct;
import java.time.LocalDate;
import java.time.format.*;

public class CustomerProductDatabase extends Database<CustomerProduct> {
    //database for customer products
public CustomerProductDatabase(String filename) {
       super(filename);
    }
//****************************************** methods **************************************** */

    @Override
    public CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        return new CustomerProduct(parts[0], parts[1], LocalDate.parse("12-10-2022",formatter));
    }

}
