package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.repos;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee,Long>  {

boolean existsByName(String name);
}
