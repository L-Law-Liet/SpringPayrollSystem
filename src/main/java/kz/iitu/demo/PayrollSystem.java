package kz.iitu.demo;

import kz.iitu.demo.config.Config;
import kz.iitu.demo.dao.EmployeeDao;
import kz.iitu.demo.events.SalaryChangeEvent;
import kz.iitu.demo.events.SalaryChangeEventHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PayrollSystem {
    SalaryCalculatorService service = new SalaryCalculatorService();
    public void listEmployees(AnnotationConfigApplicationContext context){
        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);

        System.out.println("------List of Employees--------" );
        List<Employee> employees = employeeDao.listEmployees();

        System.out.println("===================================================");
        for (Employee record : employees) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.print(", Age : " + record.getAge());
            System.out.print(", Salary : " + record.getSalary());
            System.out.println(", Type : " + record.getType());
        }
        System.out.println("===================================================");
    }

    public void getSalaried(AnnotationConfigApplicationContext context, int id){
        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
        Employee employee = employeeDao.getEmployee(id);
        System.out.println("===================================================");
        System.out.println(employee.toString());
        System.out.println("===================================================");
    }
    public void getHourly(AnnotationConfigApplicationContext context, int id, int hours){
        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
        Employee employee = employeeDao.getEmployee(id);
        float extra = 0;
        System.out.println("===================================================");
        System.out.print("ID : " + employee.getId() );
        System.out.print(", Name : " + employee.getName() );
        System.out.print(", Age : " + employee.getAge());
        if (hours > 40){
            extra = (float) (employee.getSalary() * 40 + employee.getSalary() * (hours - 40) * 1.5);
        }
        else {
            extra = employee.getSalary() * hours;
        }
        System.out.print(", Salary : " + extra);
        System.out.println(", Type : " + employee.getType());
        System.out.println("===================================================");
    }
    public void getCommision(AnnotationConfigApplicationContext context, int id, float per){
        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
        Employee employee = employeeDao.getEmployee(id);

        System.out.println("===================================================");
        System.out.print("ID : " + employee.getId() );
        System.out.print(", Name : " + employee.getName() );
        System.out.print(", Age : " + employee.getAge());
        System.out.print(", Salary : " + employee.getSalary() * per / 100);
        System.out.println(", Type : " + employee.getType());
        System.out.println("===================================================");
    }
    public void getSalCom(AnnotationConfigApplicationContext context, int id, float per) {
        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
        Employee employee = employeeDao.getEmployee(id);
        float salary = employee.getSalary() + employee.getSalary() * per / 100;
        System.out.println("===================================================");
        System.out.print("ID : " + employee.getId() );
        System.out.print(", Name : " + employee.getName() );
        System.out.print(", Age : " + employee.getAge());
        System.out.print(", Salary : " + salary);
        System.out.println(", Type : " + employee.getType());
        System.out.println("===================================================");
    }

    public void changeSalary(AnnotationConfigApplicationContext context, float per, String type) {
        EmployeeDao employeeDao = context.getBean("employeeDao", EmployeeDao.class);
        employeeDao.changeSalary(per, type);
        context.getBean("salaryChangeEventHandler", SalaryChangeEventHandler.class).onApplicationEvent(new SalaryChangeEvent(this, employeeDao.getEmployeesByType(type)));
    }
}
