package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Factory.ManagerFactory;
import za.ac.cput.Service.ManagerService;
import za.ac.cput.domain.Manager;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ManagerControllerTest {
    private final String BASE_URL = "http://localhost:8080/NMJsystem/employee";
    private static Manager m1;
    private static  Manager m2;

    @Autowired
    private TestRestTemplate restTemplate;

    Manager responsebody;
    Manager responsebody2;


    @BeforeAll
    static void a_setUp() {
        m1 = ManagerFactory.buildEmployee("Mlu", "Mbuyazi", "IT");
        System.out.println(m1);

        m2 = ManagerFactory.buildEmployee("Mbasa", "Dlamini", "Photography");
        System.out.println(m2);
    }

    @Test
    @Order(1)
    void b_create() {
        String createURL = BASE_URL + "/create";
        System.out.println(createURL);

        System.out.println("manager1 ID before posting it: " + m1.getEmployeeID());
       ResponseEntity<Manager> response = restTemplate.postForEntity(createURL, m1, Manager.class);
       assertNotNull(response);
        System.out.println("Response: " + response);

        responsebody = response.getBody();
       assertNotNull(responsebody);
       System.out.println("Object Returned by JPa after posting manager1: " + responsebody);
        System.out.println("manager1 ID after posting it: " + m1.getEmployeeID());

        ResponseEntity<Manager> response2 = restTemplate.postForEntity(createURL, m2, Manager.class);
        assertNotNull(response2);

         responsebody2 = response2.getBody();
        assertNotNull(responsebody2);
        //System.out.println("Read manager2: " + responsebody2);

    }

    @Test
    @Order(2)
    void b_read() {
    String createURL = BASE_URL + "/read/" + responsebody.getEmployeeID();
        System.out.println("URL" + createURL);

    ResponseEntity<Manager> response = restTemplate.getForEntity(createURL, Manager.class);
    assertNotNull(response);

    Manager readMananger = response.getBody();
    assertEquals(readMananger.getEmployeeID(), responsebody.getEmployeeID());
    System.out.println("Read Manager: " + readMananger);

    }

    @Test
    @Order(3)
    void d_update() {
        String updateURL = BASE_URL + "/update";
        System.out.println(updateURL);

        Manager update = new Manager.ManagerBuilder().copy(responsebody2)
                .setDepartment("Risk Data and Delivery")
                .setEmployeeID(responsebody2.getEmployeeID())
                .build();

       ResponseEntity<Manager>  response= restTemplate.postForEntity(updateURL, update, Manager.class);
       assertNotNull(response);
       assertNotNull(response.getBody());

       Manager newManager = response.getBody();

       assertEquals(newManager.getEmployeeID(), responsebody2.getEmployeeID());
       System.out.println("New Manager: " + newManager);

    }

    @Test
    @Order(4)
    void e_getAll() {
        String get_All_URl = BASE_URL + "/getAll";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        HttpEntity<String> respose = restTemplate.exchange(get_All_URl, HttpMethod.GET,entity ,String.class);


        System.out.println("All Managers: ");
        System.out.println(respose);
        System.out.println(respose.getBody());






    }
}