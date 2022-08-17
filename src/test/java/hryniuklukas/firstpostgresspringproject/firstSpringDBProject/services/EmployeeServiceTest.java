package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.services;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.EmployeeDTO;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions.EmployeeAlreadyExistsException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions.EmployeeNotFoundException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.repos.EmployeeRepo;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;
import static org.mockito.Mockito.when;

class EmployeeServiceTest {
    EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
    Mapper mapper = new Mapper();
    EmployeeService employeeService = new EmployeeService(employeeRepo, mapper);
    Employee testEmployee = new Employee("TestName", "TestRole");
    EmployeeDTO testEmployeeDTO = new EmployeeDTO("TestName", "TestRole");
    @Test
    void getEmployeeByNameTest() {
        // given
        given(employeeRepo.existsByName(testEmployee.getName())).willReturn(true);
        // when
        assertThatThrownBy(()-> employeeService.newEmployee(mapper.toDTO(testEmployee))).isInstanceOf(EmployeeAlreadyExistsException.class);
    }
    @Test
    void getEmployeeByIdTest(){
        Long id = 1L;
        given(employeeRepo.findById(id)).willReturn(Optional.of(testEmployee));
        assertThat(employeeService.findEmployeeById(id)).isEqualTo(testEmployeeDTO);
    }
    @Test
    void deleteEmployeeByIdTest(){
        Long id = 1L;
        given(employeeRepo.existsById(id)).willReturn(false);
        assertThatThrownBy(()->employeeService.removeEmployeeById(id)).isInstanceOf(EmployeeNotFoundException.class);
    }

}