package pro.sky.java.course2.EmployeeBook.model;

public class Employee {
    private final String firstName;
    private final String lastName;

    private int department;
    private int salary;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = 1;
        this.salary = 60_000;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    private String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName +
                " lastName: " + lastName +
                " department: " + department +
                " salary: " + salary;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.getFullName().equals(((Employee) other).getFullName());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(lastName);
    }

}
