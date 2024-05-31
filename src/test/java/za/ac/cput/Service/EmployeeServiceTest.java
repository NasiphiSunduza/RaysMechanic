package za.ac.cput.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.EmployeeFactory;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeServiceTest {

    private Employee emp1;
    private Employee emp2;
    private  Employee emp3;

    @Autowired
    private  EmployeeService service;


    @BeforeEach
    void setUp() {
        emp1 = EmployeeFactory.buildEmployee(01, "Thandolwethu", "Khoza");
        emp2 = EmployeeFactory.buildEmployee(02, "Mathada", "Zwivhuya");
        emp3 = EmployeeFactory.buildEmployee(03, "Shirly", "Madavha");


    }

    @Test
    void create() {
        Employee createdEmp1 = service.create(emp1);
        assertNotNull(createdEmp1);
        System.out.println(createdEmp1);

    }

    @Test
    void read() {
       Employee readEmp1 =service.read(emp1.getEmployeeID());
        assertNotNull(readEmp1);
        System.out.println(readEmp1);
    }

    @Test
    void update() {

        Employee updateObject = new Employee.employeeBuilder().copy(emp2)
                .setFirstName(emp2.getLastName())
                .setLastName(emp2.getFirstName())
                .build();

       Employee objectUpdatedToTheDatabase =  service.update(updateObject);
       assertNotNull(objectUpdatedToTheDatabase);

        System.out.println(objectUpdatedToTheDatabase);


    }

    @Test
    void getAll() {
        service.getAll();
    }
}