package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Services;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Repos.EmployeeRepo;
import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.*;

import static org.junit.jupiter.api.Assertions.*;

class Service1Test {
    EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
    @Test
    void getEmployeeByName() {
        Employee test1 = new Employee("TestName", "TestRole");
        employeeRepo.existsByName(test1.getName());
    }
}