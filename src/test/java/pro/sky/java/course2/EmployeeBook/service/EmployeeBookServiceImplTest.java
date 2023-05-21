package pro.sky.java.course2.EmployeeBook.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.EmployeeBook.exception.*;
import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.Map;

import static pro.sky.java.course2.EmployeeBook.service.EmployeeBookServiceImpl.MAX_COUNT_EMPLOYEES;

public class EmployeeBookServiceImplTest {

    private final EmployeeBookServiceImpl out = new EmployeeBookServiceImpl();

    @AfterEach
    public void afterEach() {
        for (Map.Entry<String, Employee> entry : out.getEmployees().entrySet()) {
            if (entry.getKey().contains("Abc")) {
                out.remove(entry.getValue().getLastName(), entry.getValue().getFirstName(), entry.getValue().getMiddleName());
            }
        }
    }

    @Test
    public void shouldWellWorkWhenValidInput() {
        int size = out.getEmployees().size();
        Employee result = out.add("Abc", "Abc", "Abc");
        Assertions.assertEquals(out.find("Abc", "Abc", "Abc"), result);
        Assertions.assertEquals(out.getEmployees().size(), ++size);
        Assertions.assertEquals(out.remove("Abc", "Abc", "Abc"), result);
        Assertions.assertEquals(out.getEmployees().size(), --size);
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

    @Test
    public void shouldThrowEmployeeStorageIsFullExceptionWhenSizeExceededLimit() {
        int size = out.getEmployees().size();
        Employee buffer;
        for (int i = 0; i < MAX_COUNT_EMPLOYEES - size; i++) {
            buffer = out.add("Abc", "Abc", "Abc" + ((char) 'a' + i + 1));
        }
        Assertions.assertThrows(EmployeeStorageIsFullException.class,
                () -> out.add("Abc", "Abc", "Abcz"));
    }
}
