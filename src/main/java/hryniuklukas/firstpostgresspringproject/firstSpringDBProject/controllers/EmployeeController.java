package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.controllers;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.EmployeeDTO;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions.EmployeeNotFoundException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.repos.EmployeeRepo;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    List<Employee> listAllEmployees() {
        return employeeService.listAllEmployees();
    }

    @PostMapping
    Employee newEmployee(@RequestBody EmployeeDTO newEmployee) {
        return employeeService.newEmployee(newEmployee);
    }

    @GetMapping("/{id}")
    EmployeeDTO findEmployeeById(@PathVariable Long id) {
        log.info("Hello");
        return employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    void removeEmployeeById(@PathVariable Long id) {
        employeeService.removeEmployeeById(id);
    }
}
