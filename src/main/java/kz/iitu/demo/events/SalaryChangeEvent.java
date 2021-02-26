package kz.iitu.demo.events;

import kz.iitu.demo.Employee;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class SalaryChangeEvent extends ApplicationEvent {
    private List<Employee> employees = new ArrayList<>();
    public SalaryChangeEvent(Object source, List<Employee> employees) {
        super(source);
        this.employees = employees;
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }
}
