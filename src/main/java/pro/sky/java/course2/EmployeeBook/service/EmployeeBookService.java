package pro.sky.java.course2.EmployeeBook.service;

import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.List;

public interface EmployeeBookService {
    Employee find(String firstName, String lastName);

    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    List<Employee> getEmployees();

}
