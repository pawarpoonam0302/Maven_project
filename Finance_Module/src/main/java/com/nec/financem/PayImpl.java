package com.nec.financem;


/*
* this is implenetation class for finance module
* */
public class PayImpl {

    public static void main(String[] args) {

        PayrollProcessing ps = new  PayrollProcessing();


        System.out.println("Enter Details to check if your applicable to pay tax or not");
        ps.calculateTaxBasedOnSalary();




    }
}
