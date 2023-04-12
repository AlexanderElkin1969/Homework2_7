package pro.sky.java.course2.EmployeeBook.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.EmployeeBook.model.Employee;
import pro.sky.java.course2.EmployeeBook.service.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employeeBook")
public class EmployeeBookController {

    private final EmployeeBookService employeeBookService;

    public EmployeeBookController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "<h1 style = \" color: green \">Добро пожаловать. Введите запрос.</h1>";
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam("lastName") String lastName,
                       @RequestParam("firstName") String firstName,
                       @RequestParam("middleName") String middleName) {
        try {
            return employeeBookService.find(lastName, firstName, middleName).toString() + " в списке сотрудников";
        } catch (EmployeeNotFoundException e) {
            return e.getLocalizedMessage();
        }
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("lastName") String lastName,
                      @RequestParam("firstName") String firstName,
                      @RequestParam("middleName") String middleName) {
        try {
            return employeeBookService.add(lastName, firstName, middleName).toString() + " добавлен в список сотрудников.";
        } catch (EmployeeAlreadyAdded e) {
            return e.getLocalizedMessage();
        } catch (EmployeeStorageIsFullException e) {
            return e.getLocalizedMessage();
        }
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("lastName") String lastName,
                         @RequestParam("firstName") String firstName,
                         @RequestParam("middleName") String middleName) {
        try {
            return employeeBookService.remove(lastName, firstName, middleName).toString() + " удален из списка сотрудников";
        } catch (EmployeeNotFoundException e) {
            return e.getLocalizedMessage();
        }
    }

    @GetMapping(path = "/getList")
    public Map<String, Employee> getList() {
        return employeeBookService.getEmployees();
    }

}
