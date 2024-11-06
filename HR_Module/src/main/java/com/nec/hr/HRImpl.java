package com.nec.hr;

import java.sql.SQLException;
import java.util.Scanner;


/*
* this class provides implementations to the hrservice class's methods
* */
public class HRImpl {

    static boolean ordering = true;

    public static void menu()
    {
        System.out.println("WELCOME "
                + "\n 1.Add new Employee" + " \n 2.Delete Employee" + "\n 3.Update Employee"
                +  "\n 4.Display All Employees" + "\n 5.Thank You"  );
    }

    public static void main(String[] args) throws SQLException {
        HRService service = new HRService();
        Scanner sc = new Scanner(System.in);

        do {
            menu();
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Add Employee");
                    service.hireEmployee();

                    break;
                case 2:
                    System.out.println("Delete Employee");
                    service.terminateEmployee();
                    break;
                case 3:
                    System.out.println("Update Employee");
                    service.promoteEmployee();
                    break;
                case 4:
                    System.out.println("Display All Employee");
                    service.displayAllEmp();
                    break;
                case 5:
                    System.out.println("Thank You");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please Enter Valid Choice :");
                    break;
            }
        }while(ordering);


    }

}
