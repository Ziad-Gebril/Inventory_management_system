package database;

import employee.Product;

import java.util.ArrayList;

public class ProductDatabase extends Database<Product>{

    public ProductDatabase(String fileName) {
        super(fileName);
    }

    @Override
    public Product createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new Product(parts[0], parts[1], parts[2], parts[3], Integer.valueOf(parts[4]),Float.valueOf(parts[5]));
    }

    @Override
    public String getSearchKey(Product product) {
        return product.getSearchKey();
    }

    @Override
    public String getLineRepresentation(Product product) {
        return product.lineRepresentation();
    }

    @Override
    public ArrayList<Product> returnAllRecords() {
        return records;
    }

    @Override
    public Product getRecord(String key){
        for(int i = 0; i < records.size(); i++){
            if(getSearchKey(records.get(i)).equals(key)){
                return records.get(i);
            }
        }
        return null;
    }

}
