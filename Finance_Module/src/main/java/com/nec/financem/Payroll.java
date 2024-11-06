package com.nec.financem;

/*
* this is pojo class which contains fields related to payroll process */
public class Payroll {

    private int empid;
    private double salary;
    private double tax;

    public Payroll() {
    }

    public Payroll(int empid, double salary, double tax) {
        this.empid = empid;
        this.salary = salary;
        this.tax = tax;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {

        this.empid = empid;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary <0 )
        {
            System.out.println("please Enter valid amount");
        }
        else {
            this.salary = salary;
        }
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }


    @Override
    public String toString() {
        return "Payroll{" +
                "empid=" + empid +
                ", salary=" + salary +
                ", tax=" + tax +
                '}';
    }

}
