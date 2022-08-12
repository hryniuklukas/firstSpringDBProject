package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Mapper;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.EmployeeDTO;
import org.springframework.stereotype.Component;

@Component
public abstract class Mapper {
    public static EmployeeDTO toDTO(Employee employee){
        return new EmployeeDTO(employee.getName(),employee.getRole());
    }
    public static Employee toDomain(EmployeeDTO employeeDTO)
    {
        return new Employee(employeeDTO.getName(), employeeDTO.getRole());
    }
}
