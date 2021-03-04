package kz.sitedev.jpa;

import kz.sitedev.jpa.entity.Employee;

public class SalaryCalculatorService {
    public void getSalary(Employee employee){
        System.out.println("===================================================");
        switch (employee.getType()){
            case SALARIED:
                System.out.println(employee.toString());
                break;
            case HOURLY:
                float extra = 0;
                System.out.print("ID : " + employee.getId() );
                System.out.print(", Name : " + employee.getName() );
                System.out.print(", Age : " + employee.getAge());
                if (employee.getHoursWorked() > 40){
                    extra = (float) (employee.getHourRate() * 40 + employee.getHourRate()
                            * (employee.getHoursWorked() - 40) * 1.5);
                }
                else {
                    extra = (float) (employee.getHourRate() * employee.getHoursWorked());
                }
                System.out.print(", Salary : " + extra);
                System.out.println(", Type : " + employee.getType());
                break;
            case COMMISSION:
                System.out.print("ID : " + employee.getId() );
                System.out.print(", Name : " + employee.getName() );
                System.out.print(", Age : " + employee.getAge());
                System.out.print(", Salary : " + employee.getFixedSalary() * employee.getCommRate() / 100);
                System.out.println(", Type : " + employee.getType());
                break;
            case SALCOM:
                float salary = (float) (employee.getFixedSalary() +
                        (float) (employee.getFixedSalary() * employee.getCommRate() / 100));
                System.out.print("ID : " + employee.getId() );
                System.out.print(", Name : " + employee.getName() );
                System.out.print(", Age : " + employee.getAge());
                System.out.print(", Salary : " + salary);
                System.out.println(", Type : " + employee.getType());
                break;
        }
        System.out.println("===================================================");
    }

    public double getFixedSalary(Employee employee){
        switch (employee.getType()){
            case SALARIED:
                return employee.getFixedSalary();
            case HOURLY:
                float extra = 0;
                if (employee.getHoursWorked() > 40){
                    extra = (float) (employee.getHourRate() * 40 + employee.getHourRate()
                            * (employee.getHoursWorked() - 40) * 1.5);
                }
                else {
                    extra = (float) (employee.getHourRate() * employee.getHoursWorked());
                }
                return extra;
            case COMMISSION:
                return employee.getFixedSalary() * employee.getCommRate() / 100;
            case SALCOM:
                return (employee.getFixedSalary() + (employee.getFixedSalary() * employee.getCommRate() / 100));
        }
        return 0;
    }
}
