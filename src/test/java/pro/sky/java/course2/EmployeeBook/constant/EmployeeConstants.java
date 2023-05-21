package pro.sky.java.course2.EmployeeBook.constant;

import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeConstants {

    public static final List<Employee> EMPLOYEE_LIST = new ArrayList<>(List.of(
            new Employee("Александров", "Александр", "Александрович", 1, 100_000),
            new Employee("Александров", "Борис", "Александрович", 1, 150_000),
            new Employee("Борисов", "Александр", "Александрович", 1, 200_000),
            new Employee("Александров", "Александр", "Борисович", 3, 120_000),
            new Employee("Борисов", "Борис", "Александрович", 3, 130_000)
    ));

    }
