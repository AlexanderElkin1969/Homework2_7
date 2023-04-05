package pro.sky.java.course2.EmployeeBook.service;

public class EmployeeAlreadyAdded extends RuntimeException {
    public EmployeeAlreadyAdded() {
    }

    public EmployeeAlreadyAdded(String message) {
        super(message);
    }
}
