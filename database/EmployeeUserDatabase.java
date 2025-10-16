package database;

import employee.EmployeeUser;

public class EmployeeUserDatabase extends Database<EmployeeUser> {
    public EmployeeUserDatabase(String filename) {
        super(filename);
    }

    @Override
    public EmployeeUser createRecordFrom(String line) {
        String[] parts = line.split(",");
        return new EmployeeUser(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }

    @Override
    public String getSearchKey(EmployeeUser employeeUser) {
        return employeeUser.getSearchKey();
    }

    @Override
    public String getLineRepresentation(EmployeeUser employeeUser) {
        return employeeUser.lineRepresentation();
    }

}
