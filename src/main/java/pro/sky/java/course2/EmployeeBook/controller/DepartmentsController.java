package pro.sky.java.course2.EmployeeBook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.EmployeeBook.model.Employee;
import pro.sky.java.course2.EmployeeBook.service.DepartmentsService;

import java.util.ArrayList;

@RestController
@RequestMapping("/employeeBook/departments")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping(path = "/max-salary")
    public String maxSalary(@RequestParam("departmentId") Integer department) {
        return departmentsService.maxSalary(department);
    }

    @GetMapping(path = "/min-salary")
    public String minSalary(@RequestParam("departmentId") Integer department) {
        return departmentsService.minSalary(department);
    }

    @GetMapping(path = "/all")
    public ArrayList<Employee> allOfDepartment(@RequestParam("departmentId") Integer department) {
        return departmentsService.allOfDepartment(department);
    }

    @GetMapping(path = "/all/")
    public ArrayList<Employee> allSortedToDepartment() {
        return departmentsService.allSortedToDepartment();
    }
}
