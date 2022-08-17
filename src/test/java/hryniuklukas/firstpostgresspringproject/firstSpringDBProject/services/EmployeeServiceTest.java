package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.services;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions.EmployeeAlreadyExistsException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.exceptions.EmployeeNotFoundException;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.repos.EmployeeRepo;
import org.junit.jupiter.api.Test;

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
    @Test
    void getEmployeeByNameTest() {
        // given
        Employee test1 = new Employee("TestName", "TestRole");
        given(employeeRepo.existsByName(test1.getName())).willReturn(true);
        // when
        assertThatThrownBy(()-> employeeService.newEmployee(mapper.toDTO(test1))).isInstanceOf(EmployeeAlreadyExistsException.class);
    }
//    @Test
//    void getEmployeeByIdTest(){
//        Long id = 1L;
//        given(employeeRepo.findById(id).isEmpty());
//        assertThatThrownBy(()->employeeService.findEmployeeById(id)).isInstanceOf(EmployeeNotFoundException.class);
//    }
    @Test
    void deleteEmployeeByIdTest(){
        Long id = 1L;
        given(employeeRepo.existsById(id)).willReturn(false);
        assertThatThrownBy(()->employeeService.removeEmployeeById(id)).isInstanceOf(EmployeeNotFoundException.class);

    }

}