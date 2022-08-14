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
    private final EmployeeRepo employeeRepo;
    private final EmployeeService employeeService;
    EmployeeController(EmployeeRepo employeeRepo, EmployeeService employeeService)
    {
        this.employeeRepo = employeeRepo;
        this.employeeService = employeeService;
    }
    @GetMapping
    List<Employee> listAllEmployees()
    {
        return employeeRepo.findAll();
    }
    @PostMapping
    Employee newEmployee(@RequestBody EmployeeDTO newEmployee){
        return employeeService.newEmployee(newEmployee);
    }
    @GetMapping("/{id}")
    Employee findEmployeeById(@PathVariable Long id){
        log.info("Hello");
        return employeeRepo.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));
    }
    @DeleteMapping("/{id}")
    void removeEmployeeById(){

    }
}
