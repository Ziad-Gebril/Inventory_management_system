package employee;

import database.ProductDatabase;

import java.util.ArrayList;

public class TestProduct {
    public static void main(String[] args) {

        ArrayList<Product> products;

        ProductDatabase db = new ProductDatabase("database/Product.txt");
        db.readFromFile();

        products=db.returnAllRecords();
        System.out.println(products);

        db.insertRecord(db.createRecordFrom("P7,Tablet,Samsung,TechSupplier,5,1000"));
        db.saveToFile();

        System.out.println(db.getRecord("P1"));

        db.returnAllRecords();

        System.out.println("Current products loaded from file:");
        for (Product e : db.returnAllRecords()) {
            System.out.println(e.lineRepresentation());
        }

        Product newProd = new Product("P5","EarBuds","Huawei","TechSupplier",5,500);
        db.insertRecord(newProd);

        db.saveToFile();

        System.out.println("\nAfter adding EarBuds and saving:");
        for (Product e : db.returnAllRecords()) {
            System.out.println(e.lineRepresentation());
        }

        System.out.println(db.contains("P6"));

        db.deleteRecord("P5");

        db.saveToFile();
    }

}
