package kz.sitedev.jpa.service.impl;

import kz.sitedev.jpa.EmployeeType;
import kz.sitedev.jpa.entity.Employee;
import kz.sitedev.jpa.repository.EmployeeRepository;
import kz.sitedev.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> getAllPageable() {
        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC,"name", "age"));
        return employeeRepository.findAll(pageable);
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesByType(EmployeeType type) {
        return employeeRepository.findByType(type);
    }

    public List<Employee> getEmployeesBySalaryGreaterThanAndTypeNot(double salary, EmployeeType type){
        return employeeRepository.findByFixedSalaryGreaterThanAndTypeNotLike(salary, type);
    }

    public List<Employee> getEmployeesSalaryGreaterThanAndAgeFrom(double salary, int age){
        return employeeRepository.findByFromSalaryFromAge(salary, age);
    }


    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElse(new Employee());
    }

    @Override
    public void update(Long id, Employee employee) {
        Optional<Employee> empOptional = employeeRepository.findById(id);

        if (empOptional.isPresent()) {
            Employee dbEmployee = empOptional.get();
            dbEmployee.setName(employee.getName());
            dbEmployee.setFixedSalary(employee.getFixedSalary());
            dbEmployee.setHourRate(employee.getHourRate());
            dbEmployee.setHoursWorked(employee.getHoursWorked());
            dbEmployee.setCommRate(employee.getCommRate());
            dbEmployee.setAge(employee.getAge());

            employeeRepository.save(dbEmployee);
        }
    }

    @Override
    public void updateSalaryByType(EmployeeType type, float per) {
        List<Employee> emps = employeeRepository.findByType(type);

        for (Employee emp : emps ) {
            double newSalary = emp.getFixedSalary() + emp.getFixedSalary() * per;
            emp.setFixedSalary(newSalary);
            employeeRepository.save(emp);
        }
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
