package kz.sitedev.jpa.events;

import kz.sitedev.jpa.entity.Employee;
import org.springframework.context.ApplicationEvent;

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
