package pro.sky.java.course2.EmployeeBook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.*;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService {

    public static final int MAX_COUNT_EMPLOYEES = 10;
    private static Map<String, Employee> employees = new HashMap<>(Map.of(
            "Александр Александров", new Employee("Александр", "Александров"),
            "Александр Борисов", new Employee("Александр", "Борисов"),
            "Владимир Борисов", new Employee("Владимир", "Борисов"),
            "Александр Иванов", new Employee("Александр", "Иванов"),
            "Иван Иванов", new Employee("Иван", "Иванов"),
            "Александр Егоров", new Employee("Александр", "Егоров"),
            "Александр Петров", new Employee("Александр", "Петров")
    ));

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        String str = firstName + " " + lastName;
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
    public Employee add(String firstName, String lastName) throws EmployeeAlreadyAdded, EmployeeStorageIsFullException {
        String str = firstName + " " + lastName;
        if (employees.size() == MAX_COUNT_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Список сотрудников переполнен. Число сотрудников по штату не может превышать 10 человек.");
        }
        if (employees.containsKey(str)) {
            throw new EmployeeAlreadyAdded(str + " уже есть в списке сотрудников.");
        }
        Employee buffer = new Employee(firstName, lastName);
        employees.put(str, buffer);
        return buffer;
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee buffer;
        String str = firstName + " " + lastName;
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
