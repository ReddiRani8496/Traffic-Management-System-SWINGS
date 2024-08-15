package tms.test;

import java.util.Scanner;

import tms.dao.OwnerDetailsDAO;

import tms.entities.OwnerDetailsEO;

import tms.factory.OwnerDetailsDAOFactory;
import java.sql.Date;

import java.util.ArrayList;



public class OwnerDetailsDAOTest {
    public OwnerDetailsDAO ownerDAORef = OwnerDetailsDAOFactory.createOwnerDAO();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        OwnerDetailsDAOTest ownerRef = new OwnerDetailsDAOTest(); 
        //ownerRef.testCreateOwner();
       // ownerRef.testUpdateOwner();
     //   ownerRef.testDeleteOwner();
    // ownerRef.testRetrieveOwners();
        ownerRef.testSelectByPrimaryKey();
    }
    
    public void testCreateOwner() {
        System.out.println("Enter owner Id: ");
                int ownerId = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter first name: ");
                String fName = sc.nextLine();

                System.out.println("Enter last name: ");
                String lName = sc.nextLine();

                System.out.println("Enter date of birth : ");
                String dateOfBirthStr = sc.nextLine();
                Date dob = java.sql.Date.valueOf(dateOfBirthStr);

                System.out.println("Enter landline number: ");
                String landLineNo = sc.nextLine();

                System.out.println("Enter mobile number: ");
                String mobileNo = sc.nextLine();

                System.out.println("Enter gender (M/F): ");
                String gender = sc.nextLine();

                System.out.println("Enter temporary address: ");
                String tempAddr = sc.nextLine();

                System.out.println("Enter permanent address: ");
                String permAddr = sc.nextLine();

                System.out.println("Enter pincode: ");
                int pincode = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter occupation: ");
                String occupation = sc.nextLine();

                System.out.println("Enter PAN card ID: ");
                String panCardId = sc.nextLine();

                System.out.println("Enter additional proof name: ");
                String addProofName = sc.nextLine();
                
                OwnerDetailsEO ownerEORef = new OwnerDetailsEO(ownerId, fName, lName,dob,
                                                                    landLineNo, mobileNo, gender,
                                                                      tempAddr, permAddr, pincode,
                                                                      occupation, panCardId, addProofName);
        Integer result = ownerDAORef.add(ownerEORef);
        
        if(result > 0) {
            System.out.println("Record inserted successfully");
        }
    }
    
    public void testUpdateOwner() {
        System.out.println("Enter owner Id: ");
                int ownerId = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter landline number: ");
                String landLineNo = sc.nextLine();

                System.out.println("Enter mobile number: ");
                String mobileNo = sc.nextLine();
                
                System.out.println("Enter temporary address: ");
                String tempAddr = sc.nextLine();

                System.out.println("Enter pincode: ");
                int pincode = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter occupation: ");
                String occupation = sc.nextLine();

                OwnerDetailsEO ownerEORef = new OwnerDetailsEO(ownerId, landLineNo, mobileNo, 
                                                                      tempAddr,  pincode, occupation);
                
        Integer result = ownerDAORef.update(ownerEORef);
        
        if(result > 0) {
            System.out.println("Record updated successfully");
        }
    }
    
    public void testDeleteOwner() {
        System.out.println("Enter owner Id: ");
        Integer ownerId = sc.nextInt();
      Integer result = ownerDAORef.delete(ownerId);
      if(result > 0) {
          System.out.println("Record Deleted successfully");
      }
    }
    
    public void testSelectByPrimaryKey() {
        System.out.println("panNum: ");
        String ownerId = sc.next();
        OwnerDetailsEO  ownerEORef = ownerDAORef.findByOwnerId(ownerId);
        System.out.println(ownerEORef);         
    }
    
    public void testRetrieveOwners() {
        ArrayList<OwnerDetailsEO> owners = ownerDAORef.findAllOwners();
        for(OwnerDetailsEO owner : owners) {
            System.out.println(owner);
        }    
    }
    
}
