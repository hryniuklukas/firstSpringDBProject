package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException{
    public EmployeeAlreadyExistsException(String employeeName){super("Employee " +employeeName + " already exists");}
}
