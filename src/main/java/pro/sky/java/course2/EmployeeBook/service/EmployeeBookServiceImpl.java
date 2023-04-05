package pro.sky.java.course2.EmployeeBook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {

    public static final int MAX_COUNT_EMPLOYEES = 10;
    private static List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Александр", "Александров"),
            new Employee("Александр", "Борисов"),
            new Employee("Владимир", "Борисов"),
            new Employee("Александр", "Иванов"),
            new Employee("Иван", "Иванов"),
            new Employee("Александр", "Егоров"),
            new Employee("Александр", "Петров")
    ));

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee buffer = new Employee(firstName, lastName);
        if (employees.size() == 0) {
            throw new EmployeeNotFoundException("Список сотрудников пуст.");
        }
        for (Employee employee : employees) {
            if (employee.equals(buffer)) {
                return buffer;
            }
        }
        throw new EmployeeNotFoundException(buffer + " в списке сотрудников отсутствует.");
    }

    @Override
    public Employee add(String firstName, String lastName) throws EmployeeAlreadyAdded, EmployeeStorageIsFullException {
        Employee buffer = new Employee(firstName, lastName);
        if (employees.size() == MAX_COUNT_EMPLOYEES)
            throw new EmployeeStorageIsFullException("Список сотрудников переполнен. Число сотрудников по штату не может превышать 10 человек.");
        if (employees.contains(buffer)) {
            throw new EmployeeAlreadyAdded(buffer + " уже есть в списке сотрудников.");
        }
        employees.add(buffer);
        return buffer;
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee buffer = new Employee(firstName, lastName);
        if (employees.size() == 0) {
            throw new EmployeeNotFoundException("Список сотрудников пуст.");
        }
        if (!employees.contains(buffer)) {
            throw new EmployeeNotFoundException(buffer + " в списке сотрудников отсутствует.");
        }
        employees.remove(buffer);
        return buffer;
    }

    @Override
    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }
}
