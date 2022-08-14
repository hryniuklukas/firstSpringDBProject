package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.configs;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.repos.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDB {


    @Bean
    ApplicationRunner initDatabase(EmployeeRepo employeeRepo) {
        log.info("Info");
        log.warn("Warn");
        log.debug("Debug");
        log.error("Error");
        log.trace("Trace");
        return args -> {
//            log.info("Preloading " + employeeRepo.save(new Employee("Tom Novak", "worker")));
//            log.info("Preloading " + employeeRepo.save(new Employee("John Kowalski", "forklift driver")));
        };
    }

}
