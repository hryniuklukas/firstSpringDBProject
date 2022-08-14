package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.services;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.EmployeeDTO;
import org.springframework.stereotype.Component;
@Component
public class Mapper {
    public EmployeeDTO toDTO(Employee employee){
        return new EmployeeDTO(employee.getName(),employee.getRole());
    }
    public Employee toDomain(EmployeeDTO employeeDTO)
    {
        return new Employee(employeeDTO.getName(), employeeDTO.getRole());
    }
}
