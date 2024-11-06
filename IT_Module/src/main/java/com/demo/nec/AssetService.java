package com.demo.nec;

import demo.nec.common.DatabaseConnection;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
class contains methods that used to handle the processs related to it department
like assigninng new assets to employee, creating tickets for employee
* */
public class AssetService {

    Asset as = new Asset();
    Scanner sc = new Scanner(System.in);
    Connection conn = DatabaseConnection.getConnection();
    static Logger log = Logger.getLogger(AssetService.class.getName());
    int id,assetId,RequestId;
    String assetName,assetType;
    String desc,status;



    public AssetService() {
    }

    /*
    * the use of this method is to assign new assets to employee
    * by givings all the details realted to employee and asset
    * to store in database
    * */
    public void assignAssetToEmp()
    {

        System.out.println("Enter id of employee");
        id = sc.nextInt();
        as.setAssignedEmployeeId(id);
        System.out.println("Enter Asset Id :");
        assetId = sc.nextInt();
        as.setAssetId(assetId);
        System.out.println("Enter Asset Name");
        assetName = sc.next();
        as.setAssetName(assetName);
        if(as.getAssignedEmployeeId() != 0 && as.getAssetId() != 0 && as.getAssetName() != null )
        {
            try {
                PreparedStatement pstm =
                        conn.prepareStatement("insert into asset(Empid,AssetId,AssetName) values(?,?,?)");
                pstm.setInt(1,id);
                pstm.setInt(2,assetId);
                pstm.setString(3,assetName);

                int i = pstm.executeUpdate();
                log.info("Asset Assigned to Employee "+ i + id + " of ID: "+ assetId + " " + assetName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * This method is used to create request for any issues relate to devices
    * in this methods as team takes all the details and create the new ticket
    * for the issue
    * */
    public void createRequestForIssue()
    {
        System.out.println("Enter id of employee");
        id = sc.nextInt();
        as.setAssignedEmployeeId(id);
        System.out.println("Enter Asset Id :");
        assetId = sc.nextInt();
        as.setAssetId(assetId);
        System.out.println("Enter Asset Name");
        assetName = sc.next();
        as.setAssetName(assetName);
        System.out.println("Enter Asset Type");
        assetType= sc.next();
        as.setAssetType(assetType);
        System.out.println("Enter request id");
        RequestId= sc.nextInt();
        as.setRequestId(RequestId);
        System.out.println("Enter the status");
        status = sc.next();
        as.setStatus(status);
        System.out.println("Enter the issue description");
        desc =sc.next();
        as.setIssueDescription(desc);

        if(as.getAssignedEmployeeId() != 0 && as.getAssetId() !=0 && as.getAssetType() != null && as.getAssetName()!=null
                && RequestId !=0 &&  status !=null && desc != null) {
            try {
                PreparedStatement pstm =
                        conn.prepareStatement("insert into asset_it(Emp_id,Asset_id,Asset_Type,Asset_Name,Request,Status,Description)values(?,?,?,?,?,?,?)");
                pstm.setInt(1, id);
                pstm.setInt(2, assetId);
                pstm.setString(3, assetType);
                pstm.setString(4, assetName);
                pstm.setInt(5, RequestId);
                pstm.setString(6, status);
                pstm.setString(7, desc);

                int i = pstm.executeUpdate();
                log.info("Request Created for id" + i);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}


