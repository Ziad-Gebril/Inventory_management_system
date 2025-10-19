package product;

import utils.Validator;

import database.Record;

public class Product implements Record {
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private float price;

    public Product(String productID, String productName, String manufacturerName, String supplierName, int quantity,
            float price) {
        setProductID(productID);
        setProductName(productName);
        setManufacturerName(manufacturerName);
        setSupplierName(supplierName);
        setQuantity(quantity);
        setPrice(price);
    }
    
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public float getPrice() {
        return price;
    }

    @Override
    public String lineRepresentation() {
        return productID + "," + productName + "," + manufacturerName + "," + supplierName + "," + quantity + ","
                + price;
    }

    @Override
    public String getSearchKey() {
        return productID;
    }

    public boolean setProductID(String productID) {
        if (Validator.isValidString(productID)) {
            this.productID = productID;
            return true;
        }
        System.out.println("Invalid product ID.");
        return false;
    }

    public boolean setProductName(String productName) {
        if (Validator.isValidString(productName)) {
            this.productName = productName;
            return true;
        }
        System.out.println("Invalid product name.");
        return false;
    }

    public boolean setManufacturerName(String manufacturerName) {
        if (Validator.isValidString(manufacturerName)) {
            this.manufacturerName = manufacturerName;
            return true;
        }
        System.out.println("Invalid manufacturer name.");
        return false;
    }

    public boolean setSupplierName(String supplierName) {
        if (Validator.isValidString(supplierName)) {
            this.supplierName = supplierName;
            return true;
        }
        System.out.println("Invalid supplier name.");
        return false;
    }

    public boolean setPrice(float price) {
        if (Validator.isPositiveNumber(price)) {
            this.price = price;
            return true;
        }
        System.out.println("Invalid price.");
        return false;
    }

    public boolean setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
            return true;
        }
        System.out.println("Quantity cannot be negative.");
        return false;
    }
}
