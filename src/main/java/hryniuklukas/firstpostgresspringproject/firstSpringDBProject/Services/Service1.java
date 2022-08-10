package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Services;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Exceptions.EmployeeAlreadyExistsException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Exceptions.EmployeeNotFoundException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Repos.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Service1 {
    private final EmployeeRepo employeeRepo;


    public Service1(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    ;


    public Employee newEmployee(Employee newEmployee) {
        if (employeeRepo.existsByName(newEmployee.getName())) {
           throw new EmployeeAlreadyExistsException(newEmployee.getName());
        }
        return employeeRepo.save(newEmployee);
    }
    public Employee removeEmployee(Employee employeeToBeRemoved)
    {
        if(employeeRepo.existsByName(employeeToBeRemoved.getName()))
        {
            employeeRepo.delete(employeeToBeRemoved);
            return employeeToBeRemoved;
        }throw new EmployeeNotFoundException(employeeToBeRemoved);
    }
    List<Employee> listAllEmployees() {
        return employeeRepo.findAll();
    }

}
