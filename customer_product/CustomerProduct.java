package customer_product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import database.Record;

public class CustomerProduct implements Record {

    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private Boolean paid;

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
        this.paid = false;
    }

    // ******************************** getters
    // ********************************************** */

    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductID() {
        return productID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public Boolean isPaid() {
        return paid;
    }

    // ********************************************* setters
    // ***************************************** */

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    @Override
    public String lineRepresentation() {
        String date = getDateFormated();
        return customerSSN + "," + productID + "," + date + "," + paid;
    }

    @Override
    public String getSearchKey() {
        String date = getDateFormated();
        return customerSSN + "," + productID + "," + date;
    }
    // ************************************************** helper functions ******************************************* */

    public String getDateFormated() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = getPurchaseDate().format(formatter);
        return date;
    }
}
