package kz.sitedev.jpa.controller;

import kz.sitedev.jpa.EmployeeType;
import kz.sitedev.jpa.entity.Employee;
import kz.sitedev.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeesController {
    @Autowired
    EmployeeService employeeService;

    public List<Employee> getEmployeesByType(EmployeeType type){
        return employeeService.getEmployeesByType(type);
    }

    public List<Employee> all(){
        return employeeService.getAll();
    }

    public List<Employee> getEmployeesBySalaryGreaterThanAndTypeNot(double salary, EmployeeType type){
        return employeeService.getEmployeesBySalaryGreaterThanAndTypeNot(salary, type);
    }
    public List<Employee> getEmployeesSalaryGreaterThanAndAgeFrom(double salary, int age){
        return employeeService.getEmployeesSalaryGreaterThanAndAgeFrom(salary, age);
    }
    public Employee find(long id){
        return employeeService.getById(id);
    }
    public void changeSalary(EmployeeType type, float per){
        employeeService.updateSalaryByType(type, per);
    }
}
