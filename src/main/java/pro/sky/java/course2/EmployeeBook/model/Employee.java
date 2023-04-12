package pro.sky.java.course2.EmployeeBook.model;

public class Employee {

    private final String lastName;
    private final String firstName;
    private final String middleName;
    private int department;
    private int salary;
    private final int id;

    public static int size = 0;

    public Employee(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = 1 + (int) (Math.random() * 3);            //   3 департамента
        this.salary = 100_000 + (int) (Math.random() * 100_001);
        size++;
        this.id = size;
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

    public int getId() {
        return id;
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
        return "id: " + id +
                "  ФИО: " + getName() +
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
/*    private final String firstName;
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
    } */

}
