package hryniuklukas.firstpostgresspringproject.firstSpringDBProject;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company.Employee;
import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Repos.*;

import hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Services.Service1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class FirstSpringDbProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstSpringDbProjectApplication.class, args);
    }

}
