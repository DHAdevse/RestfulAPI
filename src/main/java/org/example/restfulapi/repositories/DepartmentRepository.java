package org.example.restfulapi.repositories;

import org.example.restfulapi.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query(value="select dep.* from department as dep where dep.id = :department_id ", nativeQuery = true)
    Department getDepartmentById(@Param("department_id") long id);

}
