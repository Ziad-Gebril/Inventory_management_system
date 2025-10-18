package utils;

import java.util.ArrayList;

public class Validator {
    public static boolean isValidString(String str){
        return str != null && !str.trim().isEmpty();
    }
    public static boolean isValidEmail(String email){
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }
    public static boolean isValidPhoneNumber(String phoneNumber){
        String phoneRegex = "^[0-9]{11}$";
        return phoneNumber != null && phoneNumber.matches(phoneRegex);
    }
    public static boolean isPositiveNumber(double number){
        return number > 0;
    }
    public static boolean isIDExists(String id, ArrayList<String> existingIDs){
        for (String existingID : existingIDs){
            if (existingID.equals(id)){
                return true;
            }
        }
        return false;
    }
}
