package com.nec.hr;

/*
This is pojo class which contains fields like
name ,id,salary, of employee and also contains getter setter
 to access in hr database
* */
public class HRInfo {

    private String name;
    private int id;
    private  String role;
    private double salary;
    private String deparment;

    public HRInfo() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }


    @Override
    public String toString() {
        return "HREmployee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", deparment='" + deparment + '\'' +
                '}';
    }
}
