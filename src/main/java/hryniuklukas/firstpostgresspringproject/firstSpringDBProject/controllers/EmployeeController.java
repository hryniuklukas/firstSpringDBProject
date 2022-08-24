package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.controllers;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.EmployeeDTO;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.services.EmployeeService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    List<EmployeeDTO> listAllEmployees() {
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
    @GetMapping("/role/{givenRole}")
    List <EmployeeDTO> listAllEmployeesOfGivenRole(@PathVariable String givenRole){
        return employeeService.listAllWithGivenRole(givenRole);
    }
    @GetMapping("/name/{givenName}")
    List <EmployeeDTO> listAllEmployeesOfGivenName(@PathVariable String givenName){
        return employeeService.listAllWithName(givenName);
    }
    @DeleteMapping("/{id}")
    void removeEmployeeById(@PathVariable Long id) {
        employeeService.removeEmployeeById(id);
    }
}
