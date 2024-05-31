package za.ac.cput.Factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {
    public static Employee buildEmployee(long employeeID, String firstName, String lastName){
        if( employeeID <= 0  || Helper.isStringNull(firstName) ||  Helper.isStringNull(lastName)){

            return null ;
        }

        return new Employee.employeeBuilder().setEmployeeID(employeeID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .build();

    }

}
