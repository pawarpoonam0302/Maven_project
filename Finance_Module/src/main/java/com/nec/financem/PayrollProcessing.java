package com.nec.financem;

import demo.nec.common.DatabaseConnection;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PayrollProcessing {

    Scanner sc = new Scanner(System.in);
    Payroll pay = new Payroll();
    Connection conn = DatabaseConnection.getConnection();
    static Logger log = Logger.getLogger(PayrollProcessing.class.getName());


     /*
     this method is used to calculate salary of employee based
     on how many days employee worked and his per day salary
     * */
    public double calculateSalary(int id, int days, double perday){
        double sal=0;
        System.out.println("Enter Employee id");
        sc.nextInt();
        System.out.println("Enter days of month worked");
        sc.nextInt();
        System.out.println("Enter per day amount" );
        sc.nextInt();
        if(days <= 31 && perday > 0 ) {
           sal = days * perday;
            log.info("your" + id +"Monthly salary is " + sal + " Rs");
        }
        else
        {
            System.out.println("Enter valid amount");
        }

        return sal;
    }


    /*
    this method is used to calculate how much tax the employee have to pay based on
    employees salary package it takes the filed id, salary and check different range of
    salary and according to that it calculates the tax
    * */
    public double calculateTaxBasedOnSalary() {
        double tax=0;
        System.out.println("Enter Employee id");
        int id = sc.nextInt();
        pay.setEmpid(id);
        System.out.println("Enter you salary ");
        double salary = sc.nextDouble();
        pay.setSalary(salary);
        if (salary <= 5) {
            // No tax for salaries up to 5 LPA
            tax = 0;
            System.out.println("your salary is less than 5 LPA dont have any tax");
        } else if (salary <= 10) {
            // 10% tax on amount above 5 LPA
            tax = (salary - 5) * 0.10;

            System.out.println("your salary is " + salary + "tax amount is :"+ tax);
        } else {
            // 10% tax on 5-10 LPA and 20% tax on amount above 10 LPA
            tax = (5 * 0.10) + ((salary - 10) * 0.20);
            System.out.println("your salary is " + salary +" " + "tax amount is :"+ tax);
        }

        String insertQuery = "INSERT INTO finance (empid, empsal,emptax) VALUES (?,?,?)";
        try (PreparedStatement pstm = conn.prepareStatement(insertQuery)) {
            try {
                pstm.setInt(1,id);
                pstm.setDouble(2, salary);
                pstm.setDouble(3, tax);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pstm.executeUpdate();
            log.info("Salary and tax information saved successfully.");
        } catch (SQLException e) {
           log.error("Error inserting data: " + e.getMessage());
        }
        return tax;
    }





}



