package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
    private long employeeID;
    private String firstName;
    private String lastName;

    private Employee emp1;
    private Employee emp2;




    @BeforeEach
    void setUp() {
        employeeID = 3498;
        firstName = "Indiya";
        lastName = "Num";

        emp1 = EmployeeFactory.buildEmployee(employeeID, firstName, lastName);
        emp2 = EmployeeFactory.buildEmployee(0, "",  lastName);

    }

    @Test
    void buildEmployee() {

       // assertSame(emp1, emp2);
        System.out.println(emp1);
           assertNotNull(emp1);
//


    }
    @Test
    void nullParameterReturnsNullObject(){
      //   assertEquals(emp1, emp2);

        System.out.println(emp2);
           assertNull(emp2);


    }
}