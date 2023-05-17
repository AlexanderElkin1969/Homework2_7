package pro.sky.java.course2.EmployeeBook.service;

import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.ArrayList;

public interface DepartmentsService {

    public ArrayList<Employee> allOfDepartment(int department);

    public ArrayList<Employee> allSortedToDepartment();

    String maxSalary(int department);

    String minSalary(int department);
}
