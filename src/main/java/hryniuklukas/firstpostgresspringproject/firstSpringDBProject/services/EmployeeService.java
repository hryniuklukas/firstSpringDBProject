package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.services;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.EmployeeDTO;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions.EmployeeAlreadyExistsException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions.EmployeeNotFoundException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.repos.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service

public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final Mapper mapper;

    public EmployeeService(EmployeeRepo employeeRepo, Mapper mapper) {
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }

    public Employee newEmployee(EmployeeDTO newEmployee) {
        if (employeeRepo.existsByName(newEmployee.getName())) {
            throw new EmployeeAlreadyExistsException(newEmployee.getName());
        }
        return employeeRepo.save(mapper.toDomain(newEmployee));
    }

    public void removeEmployeeById(Long id) {
        log.info("Trying to remove employee with id: {}", id);
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
        } else {
            log.warn("Removal unsuccesfull");
            throw new EmployeeNotFoundException(id);
        }
    }

    List<Employee> listAllEmployees() {
        return employeeRepo.findAll();
    }
}
