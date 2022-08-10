package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Exceptions;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;

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
