package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Controllers;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Exceptions.EmployeeNotFoundException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Repos.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class EmployeeController {
    private final EmployeeRepo employeeRepo;
    EmployeeController(EmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    @GetMapping("/employees")
    List<Employee> listAllEmployees()
    {
        return employeeRepo.findAll();
    }
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return employeeRepo.save(newEmployee);
    }
    @GetMapping("/employees/{id}")
    Employee findEmployeeById(@PathVariable Long id){
        log.info("Hello");
        return employeeRepo.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));
    }
}
