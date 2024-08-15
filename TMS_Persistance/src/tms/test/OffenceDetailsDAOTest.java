package tms.test;


import java.io.FileInputStream;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Scanner;

import tms.dao.OffenceDetailsDAO;

import tms.entities.OffenceDetailsEO;
import tms.entities.OffenceEO;

import tms.entities.RegDetailsEO;

import tms.entities.UserMasterEO;

import tms.factory.OffenceDetailsDAOFactory;

public class OffenceDetailsDAOTest {
    
    public OffenceDetailsDAO offenceDetailsDAORef = OffenceDetailsDAOFactory.createOffenceDetailsDAO();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        OffenceDetailsDAOTest offenceRef = new OffenceDetailsDAOTest();
     //  offenceRef.testCreateOffenceDetails();
     // offenceRef.testRetrieveOffenceDetails();
     //   offenceRef.testDeleteOffenceDetails();
      //  offenceRef.testUpdateOffenceDetails();
        offenceRef.testfindAllOffenceDetailsByVehNum();
    }
    
    public void testCreateOffenceDetails() {
        System.out.println("Enter vehicle number: ");
        RegDetailsEO regDetails = new RegDetailsEO();
        regDetails.setVehNo(sc.nextLine());
       

        System.out.println("Enter the path of the image file:");
        String imagePath = sc.nextLine();
        FileInputStream fis;
        byte[] image = null;
        try {
            fis = new FileInputStream(imagePath);
            image = new byte[fis.available()];
            fis.read(image);
        } catch (Exception e) {
            System.out.println("Image not uploaded");
        }

        
//        System.out.println("Enter offence detail id: ");
//       int offenceDetailId = sc.nextInt();
       
       System.out.println("Enter offence status: ");
       String status = sc.next();
       
       System.out.println("Enter offence Id: ");
       OffenceEO offence = new OffenceEO();
       offence.setOffenceId(sc.nextInt());
       sc.nextLine();
       
        System.out.println("Enter the time (format: yyyy-MM-dd HH:mm:ss):");
        String time = sc.nextLine();
        Timestamp timestamp =Timestamp.valueOf(time);
        
        System.out.println("Enter the place: ");
        String place = sc.nextLine();
       
       System.out.println("Enter the reporter: ");
       UserMasterEO user = new UserMasterEO();
       user.setUsername(sc.nextLine());
       
        OffenceDetailsEO offenceDetailsEORef = new OffenceDetailsEO(regDetails, image, status,offence,timestamp, place,user);
        Integer result = offenceDetailsDAORef.add(offenceDetailsEORef);
        
        if(result > 0) {
            System.out.println("Record inserted successfully");
        } else {
            System.out.println("Record not inserted");
        }
    }
    public void testUpdateOffenceDetails() {
            System.out.println("Enter offence detail Id: ");
            Integer offenceDetailId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the status: ");
            String status = sc.nextLine();
            OffenceDetailsEO offenceDetailsEORef = new OffenceDetailsEO(offenceDetailId,status);
          Integer result = offenceDetailsDAORef.update(offenceDetailsEORef);
          
          if(result > 0) {
              System.out.println("Record updated successfully");
          }
        }
    
    
    public void testDeleteOffenceDetails() {
            System.out.println("Enter offence detail Id: ");
            Integer OffenceDetailId = sc.nextInt();
          Integer result = offenceDetailsDAORef.delete(OffenceDetailId);
          if(result > 0) {
              System.out.println("Record Deleted successfully");
          }
        }
        
        public void testSelectByPrimaryKey() {
            System.out.println("Enter offenceDetailId: ");
            Integer offenceDetailId = sc.nextInt();
            OffenceDetailsEO  offenceDetailsEORef = offenceDetailsDAORef.findByOffenceDetailId(offenceDetailId);
            System.out.println(offenceDetailsEORef);         
        }
        
        public void testRetrieveOffenceDetails() {
            ArrayList<OffenceDetailsEO> offences = offenceDetailsDAORef.findAllOffenceDetails();
            for(OffenceDetailsEO offence : offences) {
                System.out.println(offence);
            }    
        }
        
    public void testfindAllOffenceDetailsByVehNum() {
        ArrayList<OffenceDetailsEO> offences = offenceDetailsDAORef.findAllOffenceDetailsByVehNum("ABC123");
        for(OffenceDetailsEO offence : offences) {
            System.out.println(offence);
        }    
    }
        

}
