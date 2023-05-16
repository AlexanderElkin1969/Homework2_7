package pro.sky.java.course2.EmployeeBook.exception;

public class EmployeeStorageIsFullException extends RuntimeException {

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
