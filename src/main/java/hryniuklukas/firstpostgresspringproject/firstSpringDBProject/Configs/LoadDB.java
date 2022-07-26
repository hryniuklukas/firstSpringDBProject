package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Configs;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Repos.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    ApplicationRunner initDatabase(EmployeeRepo employeeRepo) {
        return args -> {
            log.info("Preloading " + employeeRepo.save(new Employee("Tom Novak", "worker")));
            log.info("Preloading " + employeeRepo.save(new Employee("John Kowalski", "forklift driver")));
        };
    }

}
