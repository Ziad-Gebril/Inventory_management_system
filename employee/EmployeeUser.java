package employee;

public class EmployeeUser {
    private static int secondPartOfId = 0;
    private String employeeId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    // el Constructor lly byestakhdem lma a3ml new employee w 3ayz a generate id
    // automatically
    public EmployeeUser(String name, String email, String address, String phoneNumber) {
        this.employeeId = generateNewEmployeeId();
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // el Constructor lly byestakhdem lma a3ml read mn el file w 3ayz a3ml object mn
    // el data elly fe el file
    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        updateNextId(employeeId);
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

    public String lineRepresentation() {
        return employeeId + "," + name + "," + email + "," + address + "," + phoneNumber;
    }

    public String getSearchKey() {
        return employeeId;
    }

    public static String generateNewEmployeeId() {
        secondPartOfId++;
        return "E" + secondPartOfId;
    }
    // llta2ked ya 4bab di 34an lam a3ml reading mn el file w feh employeeId already
    // akbar mn el secondPartOfId elly 3andy w kda lama a3ml generate l id gedida hyb2a fe duplicate
    // 34an kda lazm a3ml update l secondPartOfId 3ala 7asab el employeeId elly ana 3ayzo a3ml object mn el data bta3to

    private static void updateNextId(String existingId) {
        //substring(1) 34an a5od el part el rakmi bas w ab2a a3ml convert string l integer
        int num = Integer.parseInt(existingId.substring(1)); 
        if (num >= secondPartOfId) {
            secondPartOfId = num;
        }
    }
}
