package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.Company;

import lombok.Getter;
import lombok.Setter;

public class EmployeeDTO {
    @Getter
    @Setter
    String name;
    @Getter
    @Setter
    String role;


    public EmployeeDTO(String name, String role){
        this.name = name;
        this.role = role;
    }
}
