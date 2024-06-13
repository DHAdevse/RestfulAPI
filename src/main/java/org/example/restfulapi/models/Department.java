package org.example.restfulapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Table(name="department")
@Entity
@Getter @Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    String name;
    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
//    @JsonBackReference
    private Set<Employee> listEmployee = new HashSet<>();
}
