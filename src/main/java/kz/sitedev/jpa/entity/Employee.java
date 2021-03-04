package kz.sitedev.jpa.entity;


import kz.sitedev.jpa.EmployeeType;
import kz.sitedev.jpa.SalaryCalculatorService;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "salary")
    private double fixedSalary;
    private double hourRate;
    private int hoursWorked;
    private float commRate;
    private int age;
    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFixedSalary() {
        return this.fixedSalary;
    }
    public double getSalaryByGeneral(){
        return Math.round(new SalaryCalculatorService().getFixedSalary(this) * 100.0)/100.0;
    }
    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getCommRate() {
        return commRate;
    }

    public void setCommRate(float commRate) {
        this.commRate = commRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fixedSalary=" + fixedSalary +
                ", hourRate=" + hourRate +
                ", hoursWorked=" + hoursWorked +
                ", commRate=" + commRate + "%" +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
