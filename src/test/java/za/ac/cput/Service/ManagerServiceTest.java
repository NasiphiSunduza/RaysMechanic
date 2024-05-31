package za.ac.cput.Service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.ManagerFactory;
import za.ac.cput.domain.Manager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerServiceTest {

    @Autowired
    private ManagerService managerService;
   private static Manager m1;
   private static  Manager m2, m3, m4;



    @BeforeAll
      static void a_setUp() {
        m1 = ManagerFactory.buildEmployee("Mlu", "Mbuyazi", "IT");
        System.out.println(m1);
        m2 = ManagerFactory.buildEmployee("Mbasa", "Dlamini", "Photography");
        System.out.println(m2);
        m3 = ManagerFactory.buildEmployee("Mphumzi", "Mbula", "IT");
        System.out.println(m3);
        m4 = ManagerFactory.buildEmployee("Sipho", "Makhambs", "IT");
        System.out.println(m3);
    }

    @Test
    @Order(1)
    void b_create() {
        System.out.println("M1 post num:" + m1.getEmployeeID());
         Manager savedM1 = managerService.create(m1);
        System.out.println(savedM1);
        assertNotNull(savedM1);
        System.out.println("M1 pre num:" + m1.getEmployeeID());

       Manager  savedM2 = managerService.create(m2);
        assertNotNull(savedM2);
        System.out.println(savedM2);

        System.out.println(m1.getEmployeeID());

        managerService.create(m3);
        managerService.create(m4);

    }

    @Test
    @Order(2)
    void c_read() {
        Manager readM1 = managerService.read(m1.getEmployeeID());

        //System.out.println(savedM1);
        System.out.println(readM1);
        System.out.println(m1.getEmployeeID());

        assertEquals(readM1.getEmployeeID(), m1.getEmployeeID());

    }

    @Test
    @Order(3)
    void d_update() {
    }


    @Test
    @Order(4)
    void e_getAll() {
        System.out.println(managerService.getAll());
    }

    @Test
    @Order(5)
   void f_getManagersByDepartment(){
        System.out.println(managerService.findAllEmployeeByDepartment("IT"));

   }
}