package kz.iitu.demo;

import kz.iitu.demo.config.Config;
import kz.iitu.demo.dao.EmployeeDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        PayrollSystem ps = context.getBean("payrollSystem", PayrollSystem.class);
        Scanner L = new Scanner(System.in);

        int ch = -1;
        float per = 0;
        int id = 0;
        int hours = 0;
        float money = 0;

        while (ch != 0){
            System.out.println("1.List of Employees");
            System.out.println("2.Compute Salary of SALARIED Employees");
            System.out.println("3.Compute Salary of HOURLY Employees");
            System.out.println("4.Compute Salary of COMMISSION Employees");
            System.out.println("5.Compute Salary of Salaried-Commission Employees");
            System.out.println("6.Add % to Salary");
            System.out.println("0.Exit");
            ch = L.nextInt();

            switch (ch){
                case 1:
                    ps.listEmployees(context);
                    break;
                case 2:
                    System.out.println("0.Cancel");
                    System.out.println("Employee ID:");
                    id = L.nextInt();
                    if (id == 0){
                        break;
                    }
                    ps.getSalaried(context, id);
                    break;
                case 3:
                    System.out.println("0.Cancel");
                    System.out.println("Employee ID:");
                    id = L.nextInt();
                    if (id == 0){
                        break;
                    }
                    System.out.println("How Many Hours in Week");
                    hours = L.nextInt();
                    ps.getHourly(context, id, hours);
                    break;
                case 4:
                    System.out.println("0.Cancel");
                    System.out.println("Employee ID:");
                    id = L.nextInt();
                    if (id == 0){
                        break;
                    }
                    System.out.println("How Many %:");
                    per = L.nextFloat();
                    ps.getCommision(context, id, per);
                    break;
                case 5:
                    System.out.println("0.Cancel");
                    System.out.println("Employee ID:");
                    id = L.nextInt();
                    if (id == 0){
                        break;
                    }
                    System.out.println("How Many %:");
                    per = L.nextFloat();
                    ps.getSalCom(context, id, per);
                    break;
                case 6:
                    System.out.println("How Many %:");
                    per = L.nextFloat();
                    System.out.println("Type:");
                    int t = -1;
                    String et = "";
                    while ((t < 1 || t > 4) && t != 0){
                        System.out.println("1." + EmployeeType.COMMISSION);
                        System.out.println("2." + EmployeeType.SALARIED);
                        System.out.println("3." + EmployeeType.SALCOM);
                        System.out.println("4." + EmployeeType.HOURLY);
                        System.out.println("0.Cancel");
                        t = L.nextInt();
                        switch (t){
                            case 1:
                                et = EmployeeType.COMMISSION.toString();
                                break;
                            case 2:
                                et = EmployeeType.SALARIED.toString();
                                break;
                            case 3:
                                et = EmployeeType.SALCOM.toString();
                                break;
                            case 4:
                                et = EmployeeType.HOURLY.toString();
                                break;
                        }
                    }
                    if (t == 0){
                        break;
                    }
                    ps.changeSalary(context, per, et);
                    break;
            }
        }
    }
}
