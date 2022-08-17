package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.repos;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface EmployeeRepo extends JpaRepository<Employee,Long>, JpaSpecificationExecutor<Employee> {

boolean existsByName(String name);
}
