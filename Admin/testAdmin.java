package Admin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import employee.EmployeeUser;

public class testAdmin {
    public static void main(String[] args) {
        
       AdminRole Admin = new AdminRole();
       EmployeeUser[] list = Admin.getListOfEmployees();

       
       Admin.addEmployee("E16", "Ziad", "zgebro2005@gmail.com", "Alex", "01551413205");
       
       
       for(int i=0 ; i< list.length ; i++)
       {
        System.out.println(list[i].lineRepresentation());
       }
        

        Admin.removeEmployee("E16");
        Admin.logout();

       


        
    }
    
}
