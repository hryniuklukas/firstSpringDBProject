package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Repos;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Long>  {
}
