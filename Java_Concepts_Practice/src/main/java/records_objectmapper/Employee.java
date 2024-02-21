package records_objectmapper;

import java.util.Objects;

public class Employee {
    private Integer empId;
    private String firstName;
    private String lastName;
    private Double salary;
    private String designation;
    private Address address;
    private Integer yearsOfExperience;

    public Employee() {
    }

    public Employee(Integer empId, String firstName, String lastName, Double salary, String designation, Address address, Integer yearsOfExperience) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.designation = designation;
        this.address = address;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", address=" + address +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (null == o) return false;
        if (!(o instanceof Employee employee)) return false;

        if (!empId.equals(employee.empId)) return false;
        if (!firstName.equals(employee.firstName)) return false;
        if (!lastName.equals(employee.lastName)) return false;
        if (!salary.equals(employee.salary)) return false;
        if (!designation.equals(employee.designation)) return false;
        if (!address.equals(employee.address)) return false;
        return yearsOfExperience.equals(employee.yearsOfExperience);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(empId, firstName, lastName, salary, designation, address, yearsOfExperience);
        int result = empId.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + salary.hashCode();
        result = 31 * result + designation.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + yearsOfExperience.hashCode();
        return result;
    }
}
