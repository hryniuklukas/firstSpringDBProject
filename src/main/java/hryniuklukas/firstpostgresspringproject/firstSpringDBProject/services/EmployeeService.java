package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.services;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.EmployeeDTO;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions.EmployeeAlreadyExistsException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions.EmployeeNotFoundException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.repos.EmployeeRepo;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.specifications.EmployeeSpecification;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.utilities.SearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        log.info("Trying to remove employee with id: {}.", id);
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            log.info("Employee with id: {} deleted.", id);
        } else {
            log.warn("Removal unsuccesfull.");
            throw new EmployeeNotFoundException(id);
        }
    }
    public EmployeeDTO findEmployeeById(Long id)
    {
        EmployeeDTO foundEmployee;
        log.info("Trying to find employee with id: {}.", id);
        try{
        foundEmployee = mapper.toDTO(employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id)));}
        catch(EmployeeNotFoundException e){
            log.warn("Employee not found.");
            return null;
        }
        log.info("Employee with id: {} found.", id);
        return foundEmployee;

    }

    public List<EmployeeDTO> listAllEmployees() {
        log.info("Listing all employees");
        return employeeRepo.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }
    public List<EmployeeDTO> listAllWithGivenRole(String givenRole){
        log.info("Listing all employees of role: {}", givenRole);
        EmployeeSpecification spec1 = new EmployeeSpecification(new SearchCriteria("role", ":", givenRole));
        return employeeRepo.findAll(Specification.where(spec1)).stream()
                .map(mapper::toDTO)
                .toList();
    }
}
