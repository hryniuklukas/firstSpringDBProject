package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;

public class EmployeeNotFoundException  extends RuntimeException{
    public EmployeeNotFoundException(Long id)
    {
        super("Could not find employee " + id);
    }
    public EmployeeNotFoundException(Employee employeeToBeFound)
    {
        super("Could not find employee " + employeeToBeFound.getName());
    }
}
