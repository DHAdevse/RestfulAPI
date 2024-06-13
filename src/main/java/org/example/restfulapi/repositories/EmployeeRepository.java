package org.example.restfulapi.repositories;

import org.example.restfulapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //    Get List Employee of Department
    @Query(value = "select *from employee where department_id = :k_id", nativeQuery = true)
    List<Employee> getEmployeeDepartment(@Param("k_id") long department_id);
    @Query(value = "select emp.* from employee as emp join department as dep" +
            " ON dep.id = emp.department_id where emp.id= :employ_id",nativeQuery = true)
    Employee getEmployeeById(@Param("employ_id") long employ_id);
}
