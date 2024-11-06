package com.demo.nec;

import java.util.Scanner;

/* This class provides the implementation for the assetservice class*/

public class AssetServiceImpl {



    public static void main(String[] args) {

        AssetService asc = new AssetService();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("IT Department Operations:");
            System.out.println("1. Assigning Assets to Employee");
            System.out.println("2. Provide Technical Support");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Assigning Assets to Employee...");
                    asc.assignAssetToEmp();
                    break;
                case 2:
                    System.out.println("Provide Technical Support...");
                    asc.createRequestForIssue();
                    break;
                default:
                    System.out.println("Invalid choice for IT Department.");
                    break;
            }
        }while(choice >= 2);

    }
}
