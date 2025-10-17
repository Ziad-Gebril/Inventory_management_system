package employee;

import database.ProductDatabase;

public class TestProduct {
    public static void main(String[] args) {

        ProductDatabase db = new ProductDatabase("database/Product.txt");
        db.readFromFile();

        System.out.println("Current products loaded from file:");
        for (Product e : db.returnAllRecords()) {
            System.out.println(e.lineRepresentation());
        }

        Product newProd =new Product("P5","EarBuds","Huawei","TechSupplier",5,500);
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
