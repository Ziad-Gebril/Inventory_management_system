package employee;
import database.Record;
import utils.Validator;

public class EmployeeUser implements Record {
    private String employeeId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    // el Constructor lly byestakhdem lma a3ml read mn el file w 3ayz a3ml object mn
    // el data elly fe el file
    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber) {
        setEmployeeId(employeeId);
        setName(name);
        setEmail(email);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setName(String name) {
        if(Validator.isValidString(name)){
            this.name = name;
            return true;
        }
        System.out.println("Invalid name.");
        return false;
    }
    public boolean setEmail(String email) {
        if(Validator.isValidEmail(email)){
            this.email = email;
            return true;
        }
        System.out.println("Invalid email.");
        return false;
    }
    public boolean setAddress(String address) {
        if(Validator.isValidString(address)){
            this.address = address;
            return true;
        }
        System.out.println("Invalid address.");
        return false;
    }
    public boolean setPhoneNumber(String phoneNumber) {
        if(Validator.isValidPhoneNumber(phoneNumber)){
            this.phoneNumber = phoneNumber;
            return true;
        }
        System.out.println("Invalid phone number.");
        return false;
    }
    public void setEmployeeId(String employeeId) {
        if(!Validator.isValidString(employeeId)){
            System.out.println("Cannot Generate Employee ID. please try again.");
        }
        else {
            this.employeeId = employeeId;
        }
    }

    @Override
    public String lineRepresentation() {
        return employeeId + "," + name + "," + email + "," + address + "," + phoneNumber;
    }

    @Override
    public String getSearchKey() {
        return employeeId;
    }
/*
    public static String generateNewEmployeeId() {
        secondPartOfId++ ;
        return "E" + secondPartOfId;
    }
    // llta2ked ya 4bab di 34an lam a3ml reading mn el file w feh employeeId already
    // akbar mn el secondPartOfId elly 3andy w kda lama a3ml generate l id gedida
    // hyb2a fe duplicate
    // 34an kda lazm a3ml update l secondPartOfId 3ala 7asab el employeeId elly ana
    // 3ayzo a3ml object mn el data bta3to

    private static void updateNextId(String existingId) {
        // substring(1) 34an a5od el part el rakmi bas w ab2a a3ml convert string l
        // integer
        int num = Integer.parseInt(existingId.substring(1));
        if (num >= secondPartOfId) {
            secondPartOfId = num;
        }
    }*/
}
