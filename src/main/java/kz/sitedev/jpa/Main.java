package kz.sitedev.jpa;

import kz.sitedev.jpa.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        PayrollSystem ps = context.getBean("payrollSystem", PayrollSystem.class);
        Scanner L = new Scanner(System.in);

        int ch = -1;
        float per = 0;
        int id = 0;
        double money = 0;
        int t;
        EmployeeType et = EmployeeType.SALARIED;

        while (ch != 0){
            System.out.println("1.List of Employees");
            System.out.println("2.Compute Salary of Employee");
            System.out.println("3.Add % to Salary");
            System.out.println("4.Get Employees By Type");
            System.out.println("5.Get Employees From * Fixed Salary And Type Not equal to *");
            System.out.println("6.Get Employees From * Fixed Salary And Age From *");
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
                    ps.getSalary(context, id);
                    break;
                case 3:
                    t = -1;
                    System.out.println("How Many %:");
                    per = L.nextFloat();
                    System.out.println("Type:");
                    while ((t < 1 || t > 4) && t != 0){
                        System.out.println("1." + EmployeeType.COMMISSION);
                        System.out.println("2." + EmployeeType.SALARIED);
                        System.out.println("3." + EmployeeType.SALCOM);
                        System.out.println("4." + EmployeeType.HOURLY);
                        System.out.println("0.Cancel");
                        t = L.nextInt();
                        switch (t){
                            case 1:
                                et = EmployeeType.COMMISSION;
                                break;
                            case 2:
                                et = EmployeeType.SALARIED;
                                break;
                            case 3:
                                et = EmployeeType.SALCOM;
                                break;
                            case 4:
                                et = EmployeeType.HOURLY;
                                break;
                        }
                    }
                    if (t == 0){
                        break;
                    }
                    ps.changeSalary(context, per, et);
                    break;
                case 4:
                    t = -1;
                    System.out.println("Type:");
                    while ((t < 1 || t > 4) && t != 0){
                        System.out.println("1." + EmployeeType.COMMISSION);
                        System.out.println("2." + EmployeeType.SALARIED);
                        System.out.println("3." + EmployeeType.SALCOM);
                        System.out.println("4." + EmployeeType.HOURLY);
                        System.out.println("0.Cancel");
                        t = L.nextInt();
                        switch (t){
                            case 1:
                                et = EmployeeType.COMMISSION;
                                break;
                            case 2:
                                et = EmployeeType.SALARIED;
                                break;
                            case 3:
                                et = EmployeeType.SALCOM;
                                break;
                            case 4:
                                et = EmployeeType.HOURLY;
                                break;
                        }
                    }
                    if (t == 0){
                        break;
                    }
                    ps.getByType(context, et);
                    break;
                case 5:
                    t = -1;
                    System.out.println("Salary:");
                    money = L.nextDouble();
                    System.out.println("Type:");
                    while ((t < 1 || t > 4) && t != 0){
                        System.out.println("1." + EmployeeType.COMMISSION);
                        System.out.println("2." + EmployeeType.SALARIED);
                        System.out.println("3." + EmployeeType.SALCOM);
                        System.out.println("4." + EmployeeType.HOURLY);
                        System.out.println("0.Cancel");
                        t = L.nextInt();
                        switch (t){
                            case 1:
                                et = EmployeeType.COMMISSION;
                                break;
                            case 2:
                                et = EmployeeType.SALARIED;
                                break;
                            case 3:
                                et = EmployeeType.SALCOM;
                                break;
                            case 4:
                                et = EmployeeType.HOURLY;
                                break;
                        }
                    }
                    if (t == 0){
                        break;
                    }
                    ps.getEmployeesBySalaryGreaterThanAndTypeNot(context, money, et);
                    break;
                case 6:
                    System.out.println("Salary:");
                    money = L.nextDouble();
                    System.out.println("Age:");
                    int age = L.nextInt();
                    ps.getEmployeesSalaryGreaterThanAndAgeFrom(context, money, age);
                    break;

            }
        }
    }
}
