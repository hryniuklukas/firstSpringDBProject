package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException{
    public EmployeeAlreadyExistsException(String employeeName){super("Employee " +employeeName + " already exists");}
}
