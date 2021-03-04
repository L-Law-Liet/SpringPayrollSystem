package kz.sitedev.jpa.service;

import kz.sitedev.jpa.EmployeeType;
import kz.sitedev.jpa.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    void create(Employee employee);
    Page<Employee> getAllPageable();
    List<Employee> getAll();
    List<Employee> getEmployeesByType(EmployeeType type);
    List<Employee> getEmployeesBySalaryGreaterThanAndTypeNot(double salary, EmployeeType type);
    List<Employee> getEmployeesSalaryGreaterThanAndAgeFrom(double salary, int age);
    Employee getById(Long id);
    void update(Long id, Employee employee);
    void updateSalaryByType(EmployeeType type, float per);
    void delete(Long id);
}
