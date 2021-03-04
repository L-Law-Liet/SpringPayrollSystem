package kz.sitedev.jpa.events;

import kz.sitedev.jpa.entity.Employee;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {
    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        for (Employee employee : salaryChangeEvent.getEmployees()){
            System.out.println("Changed: " + employee.toString());
        }
    }
}
