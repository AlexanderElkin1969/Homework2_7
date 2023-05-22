package pro.sky.java.course2.EmployeeBook.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.EmployeeBook.model.Employee;
import pro.sky.java.course2.EmployeeBook.service.DepartmentsService;

import java.util.ArrayList;

@RestController
@RequestMapping("/department")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping(path = "/{id}/salary/max")
    public String maxSalary(@PathVariable int id) {
        return departmentsService.maxSalary(id);
    }

    @GetMapping(path = "/{id}/salary/min")
    public String minSalary(@PathVariable int id) {
        return departmentsService.minSalary(id);
    }

    @GetMapping(path = "/{id}/employees")
    public ArrayList<Employee> allOfDepartment(@PathVariable int id) {
        return departmentsService.allOfDepartment(id);
    }

    @GetMapping(path = "/employees")
    public ArrayList<Employee> allSortedToDepartment() {
        return departmentsService.allSortedToDepartment();
    }
}
