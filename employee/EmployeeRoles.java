package employee;

import customer_product.CustomerProduct;
import database.CustomerProductDatabase;
import database.ProductDatabase;
import product.Product;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class EmployeeRoles {
    final String RESET = "\u001B[0m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";

    
    private final ProductDatabase productsDb;
    private final CustomerProductDatabase custProdDb;

    public EmployeeRoles() {
        //E:\\OneDrive\\Desktop\\Programing\\Cursor\\Labs\\Lab4\\inventory\\Inventory_management_system\\product\\Product.txt
        //product/Product.txt
        //E:\\OneDrive\\Desktop\\Programing\\Cursor\\Labs\\Lab4\\inventory\\Inventory_management_system\\customer_product\\CustomerProduct.txt
        //customer_product/CustomerProduct.txt

        productsDb = new ProductDatabase("E:\\OneDrive\\Desktop\\Programing\\Cursor\\Labs\\Lab4\\inventory\\Inventory_management_system\\product\\Product.txt");
        custProdDb = new CustomerProductDatabase("E:\\OneDrive\\Desktop\\Programing\\Cursor\\Labs\\Lab4\\inventory\\Inventory_management_system\\customer_product\\CustomerProduct.txt");
        productsDb.readFromFile();
        custProdDb.readFromFile();
    }




    public void addProduct(String id, String name, String maker, String supplier, int qty) //NO PRICE IS SET , it set to ZERO
     {
        if (!productsDb.contains(id)) {
            productsDb.insertRecord(new Product(id, name, maker, supplier, qty, 0.0f));
            System.out.println(GREEN + "The Product has been ADDED Successfully......" + RESET);
            productsDb.saveToFile();
        }
        else
        {
            System.out.println(RED + "The ID you Entered is Used by Other Product......" + RESET);

        }
    }




    public Product[] getListOfProducts() {
        ArrayList<Product> list = productsDb.returnAllRecords();
        return list.toArray(new Product[0]);
    }

    public CustomerProduct[] getListOfPurchasingOperations() {
        ArrayList<CustomerProduct> list = custProdDb.returnAllRecords();
        return list.toArray(new CustomerProduct[0]);
    }

    public boolean purchaseProduct(String ssn, String productID, LocalDate date) {
        Product p = productsDb.getRecord(productID);
        if (p == null || p.getQuantity() <= 0) {
            System.out.println(RED + "insuffisient Quantity of The Product OR Wrong ID....."+ RESET);
            return false;
        }
        p.setQuantity(p.getQuantity() - 1);
        custProdDb.insertRecord(new CustomerProduct(ssn, productID, date));
        productsDb.saveToFile();
        custProdDb.saveToFile();
        System.out.println(GREEN + "Purshasing Product Operation Done Successfully.........."+ RESET);
        return true;
    }



    public double returnProduct(String ssn, String productID, LocalDate purchaseDate, LocalDate returnDate) {
        if (returnDate.isBefore(purchaseDate)) {
            return -1;
        }

        Product p = productsDb.getRecord(productID);
        if (p == null) {
            return -2;
        }

        CustomerProduct target = null;
        for (CustomerProduct c : custProdDb.returnAllRecords()) {
            if (c.getCustomerSSN().equals(ssn) && c.getProductID().equals(productID) && c.getPurchaseDate().equals(purchaseDate)) {
                target = c;
                break;
            }
        }

        if (target == null) {
            return -3;
        }
        
        long days = ChronoUnit.DAYS.between(purchaseDate, returnDate);
        if (days > 14) {
            return -4;
        }
        
        p.setQuantity(p.getQuantity() + 1);
        custProdDb.returnAllRecords().remove(target);
        productsDb.saveToFile();
        custProdDb.saveToFile();
        return p.getPrice();
    }


    public boolean applyPayment(String ssn, LocalDate date) {
        for (CustomerProduct c : custProdDb.returnAllRecords()) {
            if (c.getCustomerSSN().equals(ssn) && c.getPurchaseDate().equals(date) && !c.isPaid()) {
                c.setPaid(true);
                custProdDb.saveToFile();
                return true;
            }
        }
        return false;
    }

    public void logout() {
        productsDb.saveToFile();
        custProdDb.saveToFile();
    }
}