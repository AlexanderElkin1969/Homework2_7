package pro.sky.java.course2.EmployeeBook.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;
import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentsServiceImplTest {

    @Mock
    private EmployeeBookService employeeBookService;

    @InjectMocks
    private DepartmentsServiceImpl out;

    private Map<String, Employee> employees;

    @BeforeEach
    public void beforeEach(){
        employees = new HashMap<>(Map.of(
                "Александров Александр Александрович",
                new Employee("Александров", "Александр", "Александрович", 1, 100_000),
                "Александров Борис Александрович",
                new Employee("Александров", "Борис", "Александрович", 1, 150_000),
                "Борисов Александр Александрович",
                new Employee("Борисов", "Александр", "Александрович", 2, 200_000),
                "Александров Александр Борисович",
                new Employee("Александров", "Александр", "Борисович", 3, 120_000),
                "Борисов Борис Александрович",
                new Employee("Борисов", "Борис", "Александрович", 3, 130_000)
        ));
        when(employeeBookService.getEmployees()).thenReturn(employees);
    }

    @ParameterizedTest
    @MethodSource("employeesWithMaxSalaryTestParams")
    public void employeesWithMaxSalaryTest(int department, Employee expected) {
        Assertions.assertTrue(out.maxSalary(department).endsWith(expected.toString()));
    }


    public static Stream<Arguments> employeesWithMaxSalaryTestParams() {
        return  Stream.of(
                Arguments.of( 1, new Employee("Александров", "Борис", "Александрович", 1, 150_000)),
                Arguments.of( 2, new Employee("Борисов", "Александр", "Александрович", 2, 200_000)),
                Arguments.of( 3, new Employee("Борисов", "Борис", "Александрович", 3, 130_000))
        );
    }


}
