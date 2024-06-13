package org.example.restfulapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name ="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstname;
    @Column(name="last_name")
    private String lastname;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    @Column(name="gender")
    private String gender;
    @Column(name="Date_of_birth")
    private Date dob;
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;
}
