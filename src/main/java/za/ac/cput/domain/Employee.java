package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long employeeID;
    protected String firstName;
    protected String lastName;


    protected Employee() {
    }

    private Employee(employeeBuilder employeeBuilder) {
        this.employeeID = employeeBuilder.employeeID;
        this.firstName = employeeBuilder.firstName;
        this.lastName = employeeBuilder.lastName;

    }

    public long getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return lastName;
    }

   public static class employeeBuilder{
       private long employeeID;
       private String firstName;
       private String lastName;
       public employeeBuilder() {

       }

       public employeeBuilder copy(Employee emp){
           this.employeeID = emp.employeeID;
           this.firstName = emp.firstName;
           this.lastName = emp.lastName;

           return this;
       }

       public employeeBuilder setEmployeeID(long employeeID){
           this.employeeID = employeeID;
           return this;
       }
       public employeeBuilder setFirstName(String firstName){
           this.firstName = firstName;
           return this;
       }
       public employeeBuilder setLastName(String lastName) {
           this.lastName = lastName;
           return this;
       }

       public Employee build(){
           return new Employee(this);

       }

   }

    @Override
    public String toString() {
        return "employeeBuilder{" +
                "employeeID=" + employeeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeID == employee.employeeID && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, firstName, lastName);
    }
}
