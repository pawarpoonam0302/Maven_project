package com.nec.hr;

import demo.nec.common.DatabaseConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Scanner;

/*
This is service class which contains method related to hr process
like hire employee,terminate employee,display all data
*/
public class HRService {

    Connection conn = DatabaseConnection.getConnection();
    static Logger log = Logger.getLogger(HRService.class.getName());

    HRInfo emp = new HRInfo();
    Scanner sc = new Scanner(System.in);
    int id;
    String ename;
    double salary;
    String role;
    String department;

    /*
    * this  method is used for hiring process of employee
    * this method add the data of new employee into database
    * */
    public boolean hireEmployee() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        System.out.println("Enter Employee id");
        id = sc.nextInt();
        boolean ispresent = getEmployeeById(id);
        if (ispresent) {
            System.out.println("Employee with this is is present");
        } else {
            if (emp.getId() != id)
            {
                System.out.println("Enter Employee name:");
                ename = sc.next();
                emp.setName(ename);
                System.out.println("Enter Employee salary:");
                salary = sc.nextDouble();
                emp.setSalary(salary);
                System.out.println("Enter Your role");
                role = sc.next();
                emp.setRole(role);
                System.out.println("Enter Your department");
                department = sc.next();
                emp.setDeparment(department);

                if (emp.getName() != null && emp.getSalary() != 0 && emp.getRole() != null && emp.getDeparment() != null) {
                    PreparedStatement pstm = conn.prepareStatement("insert into hr (emp_id,e_name,salary,e_role,department)values(?,?,?,?,?)");
                    pstm.setInt(1, id);
                    pstm.setString(2, ename);
                    pstm.setDouble(3, salary);
                    pstm.setString(4, role);
                    pstm.setString(5, department);

                    int i = pstm.executeUpdate();
                    log.info("Employee Inserted" + i);

                } else {
                    log.error("please enter valid details ");
                }
            }
        }
        return ispresent;
    }


    /*
    * this method used to show the employee data
    * based on its id
    * */
    public boolean getEmployeeById(int employeeId) {
        String query = "SELECT * FROM hr WHERE emp_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Employee found, print details
                System.out.format("ID: %d\ne_name: %s\nsalary: %.2f\ne_role: %s\ndepartment: %s\n",
                        rs.getInt("emp_id"),
                        rs.getString("e_name"),
                        rs.getDouble("salary"),
                        rs.getString("e_role"),
                        rs.getString("department"));
                return true;
            } else {
                // Employee not found
                log.warn("Employee with ID " + employeeId + " not found.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
            return false;
        }
    }



    /*
    this method is used for promoting the employee by taking employee it
    it will updated the other  promotion related data of employee
    * */
    public void promoteEmployee() throws SQLException {
        Connection conn = DatabaseConnection.getConnection();

        if (emp != null) {
            System.out.println("please enter the id of employee for promotion process");
            id = sc.nextInt();
            String query = "update hr SET e_name=?,e_role =?,salary=?, department=? WHERE emp_id=?";
            if (emp.getId() == id) {
                System.out.println(" Enter employee name");
                ename = sc.next();
                emp.setName(ename);
                System.out.println("Enter employee salary");
                salary = sc.nextDouble();
                emp.setSalary(salary);
                System.out.println("Enter Employee Department");
                department = sc.next();
                emp.setDeparment(department);

                if (emp.getName() != null && emp.getSalary() != 0 && emp.getRole() != null && emp.getDeparment() != null) {
                    PreparedStatement pstm = conn.prepareStatement("insert into hr (emp_id,e_name,salary,e_role,department)values(?,?,?,?,?)");
                    pstm.setInt(1, id);
                    pstm.setString(2, ename);
                    pstm.setString(3, role);
                    pstm.setDouble(4, salary);
                    pstm.setString(5, department);

                    int i = pstm.executeUpdate();
                    System.out.println("Employee Promoted" + i);
                }

                System.out.println("Promoted employee " + emp.getName() + " to " + department + " with salary $" + emp.getSalary());
            } else {
                System.out.println("Employee with ID " + id + " not found.");
            }
        }
    }



     /*
     * this method used to terminate the employee means
     * used to remove all the data realted to employee from database
     * */
    public void terminateEmployee() throws SQLException {
        if(id !=0)
        {
            System.out.println("Enter employee id to be terminated");
            id =sc.nextInt();
            String query = "DELETE  from hr where emp_id = ?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1,id);
            pstm.executeUpdate();
           log.info("Employee Terminated");
        }
        else
        {
            log.info("Employee with ID " + emp.getId() + " not found.");
        }
    }


    /*
    * this method is used to display all the employees list
    * with there details
    * */
    public void displayAllEmp() {
        String query = "select * from hr";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.format("%d\t%s\t%.2f\t%s\t%s\n",
                        rs.getInt("emp_id"),
                        rs.getString("e_name"),
                        rs.getDouble("salary"),
                        rs.getString("e_role"),
                        rs.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
