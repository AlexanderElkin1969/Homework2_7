package pro.sky.java.course2.EmployeeBook.model;

public class Employee {

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private int department;
    private int salary;


    public Employee(String lastName, String firstName, String middleName, int department, int salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "  ФИО: " + getFullName() +
                "  Отдел: " + department +
                "  Зарплата: " + salary;
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
        return java.util.Objects.hash(department);
    }

}
