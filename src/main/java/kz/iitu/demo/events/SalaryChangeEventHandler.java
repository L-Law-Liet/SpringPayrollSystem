package kz.iitu.demo.events;

import kz.iitu.demo.Employee;
import org.springframework.context.ApplicationEvent;
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
