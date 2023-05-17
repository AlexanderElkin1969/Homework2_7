package pro.sky.java.course2.EmployeeBook.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.EmployeeBook.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.EmployeeBook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.EmployeeBook.model.Employee;

public class EmployeeBookServiceImplTest {

    private final EmployeeBookServiceImpl out = new EmployeeBookServiceImpl();


    @Test
    public void shouldWellWorkWhenValidInput() {
        int size = out.getEmployees().size();
        Employee result = out.add("Abc", "Abc", "Abc");
        Assertions.assertEquals(out.find("Abc", "Abc", "Abc"), result);
        Assertions.assertEquals( out.getEmployees().size(), ++size);
        Assertions.assertEquals(out.remove("Abc", "Abc", "Abc"), result);
        Assertions.assertEquals( out.getEmployees().size(), --size);
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFind() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.find("Abc", "Abc", "Abc"));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemove() {
        Assertions.assertThrows(EmployeeNotFoundException.class,
                () -> out.remove("Abc", "Abc", "Abc"));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenReAdd() {
        Employee result = out.add("Abc", "Abc", "Abc");
        Assertions.assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.add("Abc", "Abc", "Abc"));
    }
}
