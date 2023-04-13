package pro.sky.java.course2.EmployeeBook.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.EmployeeBook.model.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{

private final EmployeeBookService employeeBookService;

public DepartmentsServiceImpl(EmployeeBookService employeeBookService) {
    this.employeeBookService = employeeBookService;
}
@Override
public ArrayList<Employee> allOfDepartment(Integer dep){
    return employeeBookService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() ==  dep)
                .collect(Collectors.toCollection(ArrayList::new));
}
}
