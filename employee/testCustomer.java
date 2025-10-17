package employee;

import java.time.LocalDate;

public class testCustomer {
    public static void main(String[] args) {
    
        CustomerProduct customerProduct = new CustomerProduct("1234567890", "P1234567890", LocalDate.now());
        System.out.println(customerProduct.lineRepresentation());
    }
}
