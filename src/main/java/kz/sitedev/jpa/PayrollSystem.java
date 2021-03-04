package kz.sitedev.jpa;

import kz.sitedev.jpa.controller.EmployeesController;
import kz.sitedev.jpa.entity.Employee;
import kz.sitedev.jpa.events.SalaryChangeEvent;
import kz.sitedev.jpa.events.SalaryChangeEventHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PayrollSystem {
    SalaryCalculatorService service = new SalaryCalculatorService();
    public void listEmployees(AnnotationConfigApplicationContext context){
        EmployeesController controller = context.getBean("employeesController", EmployeesController.class);

        System.out.println("------List of Employees--------" );
        List<Employee> employees = controller.all();

        System.out.println("===================================================");
        for (Employee record : employees) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.print(", Age : " + record.getAge());
            System.out.print(", Salary : " + record.getSalaryByGeneral());
            System.out.println(", Type : " + record.getType());
        }
        System.out.println("===================================================");
    }

    public void getSalary(AnnotationConfigApplicationContext context, int id){
        EmployeesController controller = context.getBean("employeesController", EmployeesController.class);
        Employee employee = controller.find(id);
        service.getSalary(employee);

    }

    public void changeSalary(AnnotationConfigApplicationContext context, float per, EmployeeType type) {
        EmployeesController controller = context.getBean("employeesController", EmployeesController.class);
        controller.changeSalary(type, per);
        context.getBean("salaryChangeEventHandler", SalaryChangeEventHandler.class)
                .onApplicationEvent(
                        new SalaryChangeEvent(this, controller.getEmployeesByType(type))
                );
    }
    public void getByType(AnnotationConfigApplicationContext context, EmployeeType type){
        EmployeesController controller = context.getBean("employeesController", EmployeesController.class);
        List<Employee> employees = controller.getEmployeesByType(type);

        System.out.println("===================================================");
        for (Employee record : employees) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.print(", Age : " + record.getAge());
            System.out.print(", Salary : " + record.getSalaryByGeneral());
            System.out.println(", Type : " + record.getType());
        }
        System.out.println("===================================================");
    }
    public void getEmployeesBySalaryGreaterThanAndTypeNot(AnnotationConfigApplicationContext context, double salary, EmployeeType type){
        EmployeesController controller = context.getBean("employeesController", EmployeesController.class);
        List<Employee> employees = controller.getEmployeesBySalaryGreaterThanAndTypeNot(salary, type);

        System.out.println("===================================================");
        for (Employee record : employees) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.print(", Age : " + record.getAge());
            System.out.print(", Salary : " + record.getSalaryByGeneral());
            System.out.println(", Type : " + record.getType());
        }
        System.out.println("===================================================");
    }
    public void getEmployeesSalaryGreaterThanAndAgeFrom(AnnotationConfigApplicationContext context, double salary, int age){
        EmployeesController controller = context.getBean("employeesController", EmployeesController.class);
        List<Employee> employees = controller.getEmployeesSalaryGreaterThanAndAgeFrom(salary, age);

        System.out.println("===================================================");
        for (Employee record : employees) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.print(", Age : " + record.getAge());
            System.out.print(", Salary : " + record.getSalaryByGeneral());
            System.out.println(", Type : " + record.getType());
        }
        System.out.println("===================================================");
    }

}
