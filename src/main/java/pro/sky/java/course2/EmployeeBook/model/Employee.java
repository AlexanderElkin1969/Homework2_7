package pro.sky.java.course2.EmployeeBook.model;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final int id;

    public static int size = 0;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        size++;
        this.id = size;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "{ firstName: " + firstName + " lastName: " + lastName + " }";
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        return this.toString().equals(other.toString());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(lastName);
    }

}
