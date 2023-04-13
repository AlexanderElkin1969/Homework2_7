package pro.sky.java.course2.EmployeeBook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.EmployeeBook.model.Employee;
import pro.sky.java.course2.EmployeeBook.service.DepartmentsService;
import pro.sky.java.course2.EmployeeBook.service.EmployeeBookService;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/employeeBook/departments")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping(path = "/all")
    public ArrayList<Employee> allOfDepartment(@RequestParam("department") Integer department) {
        return departmentsService.allOfDepartment(department);
    }
}
