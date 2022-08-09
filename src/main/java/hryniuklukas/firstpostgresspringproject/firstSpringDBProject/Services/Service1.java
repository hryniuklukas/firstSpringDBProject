package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Services;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Repos.EmployeeRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Service

public class Service1 {
    @PersistenceContext
    private EntityManager entityManager;
    private final EmployeeRepo employeeRepo;
    public Service1(EmployeeRepo employeeRepo){this.employeeRepo = employeeRepo;}
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();;
    public List<Employee> getEmployeeByName(Employee emp) {
        CriteriaQuery<Employee> cq = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);
        List<Predicate> predicateList = new ArrayList<>();
        if (emp.getName() != null) {
            predicateList.add(criteriaBuilder.equal(employee.get("name"), emp.getName()));
        }
        cq.where(predicateList.toArray(new Predicate[0]));

        return entityManager.createQuery(cq).getResultList();

    }
    List<Employee> listAllEmployees(){return employeeRepo.findAll();}

}
