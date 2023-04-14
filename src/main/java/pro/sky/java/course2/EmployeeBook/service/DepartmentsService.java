package pro.sky.java.course2.EmployeeBook.service;

import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.ArrayList;

public interface DepartmentsService {

    public ArrayList<Employee> allOfDepartment(Integer department);

    public ArrayList<Employee> allSortedToDepartment();

    String maxSalary(Integer department);

    String minSalary(Integer department);
}
