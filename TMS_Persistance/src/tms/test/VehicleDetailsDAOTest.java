package tms.test;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Scanner;


import tms.dao.VehicleDetailsDAO;


import tms.entities.VehicleDetailsEO;

import tms.factory.VehicleDetailsDAOFactory;

public class VehicleDetailsDAOTest {
     private VehicleDetailsDAO vehicleDAORef = VehicleDetailsDAOFactory.createVehicleDetailsDAO();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        VehicleDetailsDAOTest vehicleRef = new VehicleDetailsDAOTest();
     //   vehicleRef.testCreateVehicleDetails();
       // vehicleRef.testUpdateVehicleDetails();
        vehicleRef.testRetrieveVehicleDetails();
    }
    
    public void testCreateVehicleDetails() {
//        System.out.println("Enter vehicle Id: ");
//        int vehId = sc.nextInt();
//        sc.nextLine();

        System.out.println("Enter vehicle type: ");
        String vehType = sc.nextLine();

        System.out.println("Enter engine number: ");
        String engineNo = sc.nextLine();

        System.out.println("Enter model number: ");
        String modelNo = sc.nextLine();

        System.out.println("Enter vehicle name: ");
        String vehName = sc.nextLine();

        System.out.println("Enter vehicle color: ");
        String vehColor = sc.nextLine();

        System.out.println("Enter manufacturer name: ");
        String manufacturerName = sc.nextLine();

        System.out.println("Enter date of manufacture (YYYY-MM-DD): ");
        String dateOfManufactureStr = sc.nextLine();
        Date manufacture = java.sql.Date.valueOf(dateOfManufactureStr);

        System.out.println("Enter number of cylinders: ");
        int noOfCylinders = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter cubic capacity: ");
        int cubicCapacity = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter fuel used: ");
        String fuelUsed = sc.nextLine();

        System.out.println("Enter chassis number: ");
        String chassisNo = sc.nextLine();
        
        VehicleDetailsEO vehicleEORef = new VehicleDetailsEO( vehType, engineNo, modelNo, vehName,
                                                                vehColor, manufacturerName, manufacture,
                                                                noOfCylinders, cubicCapacity, fuelUsed, chassisNo);
        
        Integer result = vehicleDAORef.add(vehicleEORef);
        
        if(result > 0) {
            System.out.println("Record inserted successfully");
        }
    }
    
    public void testUpdateVehicleDetails() {
        System.out.println("Enter vehicle Id: ");
        int vehId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter vehicle color: ");
        String vehColor = sc.nextLine();

       
        
        VehicleDetailsEO vehicleEORef = new VehicleDetailsEO(vehId,vehColor);
        
        Integer result = vehicleDAORef.update(vehicleEORef);
        
        if(result > 0) {
            System.out.println("Record updated successfully");
        }
    }

    public void testdeleteVehicles() {
        System.out.println("Enter vehicle id: ");
        int vehId = sc.nextInt();
        Integer result = vehicleDAORef.delete(vehId);
        
        if(result > 0) {
            System.out.println("Record deleted successfully");
        }
    }
     public void testSelectByPrimaryKey() {
         System.out.println("Enter vehicle id: ");
         int vehId = sc.nextInt();
         VehicleDetailsEO vehicleEo = vehicleDAORef.findByVehId(vehId);
         System.out.println(vehicleEo);
     }
     
     public void testRetrieveVehicleDetails() {
         ArrayList<VehicleDetailsEO> vehicles = vehicleDAORef.findAllVehicleDetails();
         for(VehicleDetailsEO vehicle : vehicles) {
             System.out.println(vehicle);
         }
         
     }
 }

