package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode

public class EmployeeDTO {
    String name;
    String role;
}
