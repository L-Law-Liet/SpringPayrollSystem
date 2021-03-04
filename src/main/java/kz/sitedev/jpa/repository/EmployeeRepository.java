package kz.sitedev.jpa.repository;

import kz.sitedev.jpa.EmployeeType;
import kz.sitedev.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee>findByType(EmployeeType type);
    List<Employee>findByFixedSalaryGreaterThanAndTypeNotLike(double salary, EmployeeType type);

    @Query(value = "select * from employees where salary > :salary and age > :age", nativeQuery = true)
    List<Employee> findByFromSalaryFromAge(double salary, int age);
}
