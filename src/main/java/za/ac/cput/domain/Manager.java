package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Manager extends Employee{

    private String department;
    protected Manager() {

    }

    private Manager(ManagerBuilder emp) {
        this.employeeID = emp.employeeID;

        this.firstName = emp.firstName;
        this.lastName = emp.lastName;

        this.department = emp.department;

    }

    //public long getManagerID() {
   //     return managerID;
   // }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Manager{" +
               // "managerID=" + managerID +
                ", department='" + department + '\'' +
                ", employeeID=" + employeeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class ManagerBuilder{
        private long employeeID;
        private String firstName;
        private String lastName;

        //private long managerID;
        private String department;

        public ManagerBuilder() {
        }

        public ManagerBuilder setEmployeeID(long employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public ManagerBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ManagerBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

//        public ManagerBuilder setManagerID(long managerID) {
//            this.managerID = managerID;
//            return this;
//        }

        public ManagerBuilder setDepartment(String department) {
            this.department = department;
            return this;
        }
        public ManagerBuilder copy(Manager emp){
            this.employeeID = emp.employeeID;
            this.firstName = emp.firstName;
            this.lastName = emp.lastName;
            this.department = emp.department;
          //  this.managerID = emp.managerID;

            return this;
        }
        public Manager build(){
            return new Manager(this);
        }

    }

}
