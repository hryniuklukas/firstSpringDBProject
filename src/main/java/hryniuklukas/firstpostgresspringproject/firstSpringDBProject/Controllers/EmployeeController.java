package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Controllers;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Exceptions.EmployeeNotFoundException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Repos.EmployeeRepo;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Services.Service1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class EmployeeController {
    private final EmployeeRepo employeeRepo;
    private final Service1 service1;
    EmployeeController(EmployeeRepo employeeRepo, Service1 service1)
    {
        this.employeeRepo = employeeRepo;
        this.service1 = service1;
    }
    @GetMapping("/employees")
    List<Employee> listAllEmployees()
    {
        return employeeRepo.findAll();
    }
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return service1.newEmployee(newEmployee);
    }
    @GetMapping("/employees/{id}")
    Employee findEmployeeById(@PathVariable Long id){
        log.info("Hello");
        return employeeRepo.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException(id));
    }
}
