package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Services;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Repos.EmployeeRepo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.mock;

class Service1Test {
    EmployeeRepo employeeRepo = mock(EmployeeRepo.class);
    Service1 service1 = new Service1(employeeRepo);
    @Test
    void getEmployeeByName() {
        // given
        Employee test1 = new Employee("TestName", "TestRole");
        given(employeeRepo.existsByName(test1.getName())).willReturn(true);
        // when
        assertThatThrownBy(()->service1.newEmployee(test1)).isInstanceOf(RuntimeException.class);
    }
}