package pro.sky.java.course2.EmployeeBook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.EmployeeBook.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.EmployeeBook.exception.EmployeeNotFoundException;
import pro.sky.java.course2.EmployeeBook.exception.EmployeeStorageIsFullException;
import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.*;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {

    public static final int MAX_COUNT_EMPLOYEES = 30;
    private static Map<String, Employee> employees = new HashMap<>(Map.of(
            "Александров Александр Александрович", new Employee("Александров", "Александр", "Александрович"),
            "Александров Борис Александрович", new Employee("Александров", "Борис", "Александрович"),
            "Борисов Александр Александрович", new Employee("Борисов", "Александр", "Александрович"),
            "Александров Александр Борисович", new Employee("Александров", "Александр", "Борисович"),
            "Борисов Борис Александрович", new Employee("Борисов", "Борис", "Александрович"),
            "Борисов Борис Борисович", new Employee("Борисов", "Борис", "Борисович"),
            "Александров Александр Иванович", new Employee("Александров", "Александр", "Иванович"),
            "Иванов Александр Александрович", new Employee("Иванов", "Александр", "Александрович"),
            "Иванов Иван Александрович", new Employee("Иванов", "Иван", "Александрович"),
            "Иванов Иван Иванович", new Employee("Иванов", "Иван", "Иванович")
    ));

    @Override
    public Employee find(String lastName, String firstName, String middleName) throws EmployeeNotFoundException {
        String str = lastName + " " + firstName + " " + middleName;
        if (employees.size() == 0) {
            throw new EmployeeNotFoundException("Список сотрудников пуст.");
        }
        if (employees.containsKey(str)) {
            return employees.get(str);
        } else {
            throw new EmployeeNotFoundException(str + " в списке сотрудников отсутствует.");
        }
    }

    @Override
    public Employee add(String lastName, String firstName, String middleName) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        String str = lastName + " " + firstName + " " + middleName;
        if (employees.size() == MAX_COUNT_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Список сотрудников переполнен. Число сотрудников по штату не может превышать 30 человек.");
        }
        if (employees.containsKey(str)) {
            throw new EmployeeAlreadyAddedException(str + " уже есть в списке сотрудников.");
        }
        Employee buffer = new Employee(lastName, firstName, middleName);
        employees.put(str, buffer);
        return buffer;
    }

    @Override
    public Employee remove(String lastName, String firstName, String middleName) throws EmployeeNotFoundException {
        Employee buffer;
        String str = lastName + " " + firstName + " " + middleName;
        if (employees.size() == 0) {
            throw new EmployeeNotFoundException("Список сотрудников пуст.");
        }
        if (employees.containsKey(str)) {
            buffer = employees.get(str);
            employees.remove(str);
            return buffer;
        } else {
            throw new EmployeeNotFoundException(str + " в списке сотрудников отсутствует.");
        }
    }

    @Override
    public Map<String, Employee> getEmployees() {
        return Map.copyOf(employees);
    }
}
