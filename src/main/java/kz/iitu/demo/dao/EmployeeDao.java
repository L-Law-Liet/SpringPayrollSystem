package kz.iitu.demo.dao;

import kz.iitu.demo.Employee;
import kz.iitu.demo.EmployeeRowMapper;
import kz.iitu.demo.EmployeeType;
import kz.iitu.demo.events.SalaryChangeEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class EmployeeDao {
    private JdbcTemplate jdbcTemplateObject = new JdbcTemplate(
            new DriverManagerDataSource(
                    "jdbc:mysql://localhost:3306/payroll_db",
                    "root",
                    "root")
    );

    public List<Employee> listEmployees() {
        String SQL = "select * from employees";
        return jdbcTemplateObject.query(SQL, new EmployeeRowMapper());

    }

    public Employee getEmployee(int id) {
        String sql = "SELECT * FROM EMPLOYEES WHERE ID = " + id;
        return jdbcTemplateObject.queryForObject(sql, new EmployeeRowMapper());
    }

    public List<Employee> getEmployeesByType(String type) {
        String sql = "SELECT * FROM EMPLOYEES WHERE TYPE = '" + type + "'";
        return jdbcTemplateObject.query(sql, new EmployeeRowMapper());
    }

    public void changeSalary(float per, String type){
        per /= 100;
        per++;
        String SQL = "update employees set salary = salary * " + per + " where type = '" + type + "'";
        jdbcTemplateObject.update(SQL);
        System.out.println("Updated!");
    }
}
