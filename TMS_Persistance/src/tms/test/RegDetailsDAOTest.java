package tms.test;

import java.util.Scanner;

import  java.sql.Date;

import java.util.ArrayList;

import tms.dao.RegDetailsDAO;

import tms.entities.OwnerDetailsEO;
import tms.entities.RegDetailsEO;

import tms.entities.VehicleDetailsEO;

import tms.factory.RegDetailsDAOFactory;

public class RegDetailsDAOTest {
    public RegDetailsDAO regDetailsDAORef = RegDetailsDAOFactory.createRegDetailsDAO();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        RegDetailsDAOTest regDetails = new RegDetailsDAOTest();
        regDetails.testCreateRegDetails();
       // regDetails.testdeleteRegDetails();
     //  regDetails.testRetrieveRegDetails();
     //   regDetails.testSelectByPrimaryKey();
    }
    
    public void testCreateRegDetails() {
        System.out.println("Enter application number: ");
        int appNo = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter vehicle number: ");
        String vehNo = sc.nextLine();

        System.out.println("Enter vehicle ID: ");
        VehicleDetailsEO vehicle = new VehicleDetailsEO();
        vehicle.setVehId(sc.nextInt());
   

        System.out.println("Enter owner ID: ");
        OwnerDetailsEO owner = new OwnerDetailsEO();
        owner.setOwnerId(sc.nextInt());
        sc.nextLine();
        
        System.out.println("Enter date of purchase (YYYY-MM-DD): ");
        String dateOfPurchaseStr = sc.nextLine();
        Date dateOfPurchase = java.sql.Date.valueOf(dateOfPurchaseStr);

        System.out.println("Enter distributor name: ");
        String distributorName = sc.nextLine();

        RegDetailsEO regDetailsEORef = new RegDetailsEO(appNo, vehNo, vehicle, owner, dateOfPurchase, distributorName);
        Integer result = regDetailsDAORef.add(regDetailsEORef);

        if (result > 0) {
            System.out.println("Record inserted successfully");
        }
    }
    
    public void testUpdateRegDetails() {
        System.out.println("Enter vehicle no: ");
        String vehNo = sc.next();
        
        System.out.println("Enter owner ID: ");
        OwnerDetailsEO owner = new OwnerDetailsEO();
        owner.setOwnerId(sc.nextInt());
        
        RegDetailsEO regDetails = new RegDetailsEO(vehNo,owner);
        Integer result = regDetailsDAORef.update(regDetails);
        if(result > 0) {
            System.out.println("Record updated successfully");
        }
    }
    
    public void testdeleteRegDetails() {
        System.out.println("Enter vehicle no: ");
        String vehNo = sc.next();
        Integer result = regDetailsDAORef.delete(vehNo);
        
        if(result > 0) {
            System.out.println("Record deleted successfully");
        }
    }
    
    public void testSelectByPrimaryKey() {
        System.out.println("Enter vehicle number: ");
        String vehNo = sc.next();
        RegDetailsEO regDetailsEO = regDetailsDAORef.findByVehNo(vehNo);
        System.out.println(regDetailsEO);
    }
    
    public void testRetrieveRegDetails() {
        ArrayList<RegDetailsEO> regDetails = regDetailsDAORef.findAllRegDetails();
        for(RegDetailsEO detail : regDetails) {
            System.out.println(detail);
        }     
    }

}
