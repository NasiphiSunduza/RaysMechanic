package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Manager;

import static org.junit.jupiter.api.Assertions.*;

class ManagerFactoryTest {
    private String department;
    private String firstName;
    private String lastName;

    private Manager manager1;
    private  Manager manager2;



    @BeforeEach
    void setUp() {
        manager1 = ManagerFactory.buildEmployee("Mlu", "Mbuyazi", "IT");

        manager2 = ManagerFactory.buildEmployee("", "Mbuyazi", "IT");

    }

    @Test
    void buildEmployee() {
        System.out.println(manager1);
        assertNotNull(manager1);
    }
    @Test
    void buildEmployeeWithInvalidDetails() {
        System.out.println(manager2);
        assertNull(manager2);
    }
}