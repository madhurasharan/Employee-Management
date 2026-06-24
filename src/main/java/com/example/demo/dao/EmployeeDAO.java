package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.beans.Employee;
import com.example.demo.util.DBConnection;

@Repository
public class EmployeeDAO {

    // ADD
    public Employee addEmployee(Employee emp) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "INSERT INTO madhu_employee(empid, empname, salary) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, emp.getEmpId());
            ps.setString(2, emp.getEmpName());
            ps.setDouble(3, emp.getSalary());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return emp;
    }

    // GET ONE
    public Employee getEmployee(int empId) {

        Employee emp = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "SELECT * FROM madhu_employee WHERE empid=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, empId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                emp = new Employee();

                emp.setEmpId(rs.getInt("empid"));
                emp.setEmpName(rs.getString("empname"));
                emp.setSalary(rs.getDouble("salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return emp;
    }

    // GET ALL
    public List<Employee> getEmployees() {

        List<Employee> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "SELECT * FROM madhu_employee";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Employee emp = new Employee();

                emp.setEmpId(rs.getInt("empid"));
                emp.setEmpName(rs.getString("empname"));
                emp.setSalary(rs.getDouble("salary"));

                list.add(emp);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // UPDATE
    public Employee updateEmployee(int empId, Employee emp) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "UPDATE madhu_employee SET empname=?, salary=? WHERE empid=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, emp.getEmpName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, empId);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return emp;
    }

    // DELETE
    public boolean deleteEmployee(int empId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "DELETE FROM madhu_employee WHERE empid=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, empId);

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}