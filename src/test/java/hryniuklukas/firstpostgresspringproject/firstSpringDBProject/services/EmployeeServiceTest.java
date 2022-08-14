package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.services;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions.EmployeeAlreadyExistsException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.repos.EmployeeRepo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

class EmployeeServiceTest {
    EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
    Mapper mapper = new Mapper();
    EmployeeService employeeService = new EmployeeService(employeeRepo, mapper);
    @Test
    void getEmployeeByName() {
        // given
        Employee test1 = new Employee("TestName", "TestRole");
        given(employeeRepo.existsByName(test1.getName())).willReturn(true);
        // when
        assertThatThrownBy(()-> employeeService.newEmployee(mapper.toDTO(test1))).isInstanceOf(EmployeeAlreadyExistsException.class);
    }
}