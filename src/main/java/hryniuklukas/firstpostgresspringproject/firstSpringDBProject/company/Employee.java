package hryniuklukas.firstpostgresspringproject.firstSpringDBProject.company;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Employee {
    @EqualsAndHashCode.Include
    private @Id @GeneratedValue Long id;
    @EqualsAndHashCode.Include
    private String name;
    @EqualsAndHashCode.Include
    private String role;


    public Employee(String name, String role)
    {
        this.name = name;
        this.role = role;
    }

}
