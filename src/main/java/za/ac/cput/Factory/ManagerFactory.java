package za.ac.cput.Factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Manager;
import za.ac.cput.util.Helper;

public class ManagerFactory {
    public static Manager buildEmployee( String firstName, String lastName, String department){
        if( Helper.isStringNull(department) || Helper.isStringNull(firstName) ||  Helper.isStringNull(lastName)){

            return null ;
        }

        return new Manager.ManagerBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setDepartment(department)
                .build();
    }

}
