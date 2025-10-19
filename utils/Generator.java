package utils;

import java.util.Random;

public class Generator {
    public static String generateEmployeeRandomId() {
         Random rand = new Random();
        int randomNum = rand.nextInt(1000, 9999);
        return "E" + String.valueOf(randomNum);
    }
    public static String generateProductRandomId() {
         Random rand = new Random();
        int randomNum = rand.nextInt(1000, 9999);
        return "P" + String.valueOf(randomNum);
    }
     public static String generateCustomerRandomId() {
         Random rand = new Random();
        int randomNum = rand.nextInt(100000000, 999999999);
        return String.valueOf(randomNum);
    }
}
