package pro.sky.java.course2.EmployeeBook.model;

public class Employee {

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private int department;
    private int salary;


    public Employee(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = 1 + (int) (Math.random() * 3);            //   3 департамента
        this.salary = 100_000 + (int) (Math.random() * 100_001);
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

    private String getName() {
        return lastName + " " + firstName + " " + middleName;
    }

    @Override
    public String toString() {
        return "  ФИО: " + getName() +
                "  Отдел: " + department +
                "  Зарплата: " + salary;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.getName().equals(((Employee) other).getName());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(department);
    }
}
