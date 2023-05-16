package pro.sky.java.course2.EmployeeBook.service;

import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.Map;

public interface EmployeeBookService {
    Employee find(String lastName, String firstName, String middleName);

    Employee add(String lastName, String firstName, String middleName);

    Employee remove(String lastName, String firstName, String middleName);

    Map<String, Employee> getEmployees();

}
