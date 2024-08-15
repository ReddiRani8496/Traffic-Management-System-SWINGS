package tms.test;

import java.util.ArrayList;
import java.util.Scanner;

import tms.dao.OffenceDAO;

import tms.entities.OffenceEO;

import tms.factory.OffenceDAOFactory;

public class OffenceDAOTest {
    
    public OffenceDAO offenceDAORef = OffenceDAOFactory.createOffenceDAO();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        OffenceDAOTest offenceTestRef = new OffenceDAOTest();
        //offenceTestRef.testCreateOffence();
        //offenceTestRef.testUpdateOffence();
        offenceTestRef.testSelectByPrimaryKey();
     // offenceTestRef.testRetrieveOffence();
       // offenceTestRef.testDeleteOffence();
    }
    
    public void testCreateOffence() {
//        System.out.println("Enter offence Id: ");
//        int offenceId = sc.nextInt();
//        sc.nextLine();

        System.out.println("Enter offence type: ");
        String offenceType = sc.nextLine();

        System.out.println("Enter penalty: ");
        int penalty = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter vehicle type: ");
        String vehType = sc.nextLine();

        OffenceEO offenceEORef = new OffenceEO( offenceType,penalty,vehType);
        Integer result = offenceDAORef.add(offenceEORef);
        
        if(result > 0) {
            System.out.println("Record inserted successfully");
        }
    }
    
    public void testUpdateOffence() {
        System.out.println("Enter offence Id: ");
        int offenceId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter offence type: ");
        String offenceType = sc.nextLine();

        System.out.println("Enter penalty: ");
        int penalty = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter vehicle type: ");
        String vehType = sc.nextLine();
        OffenceEO offenceEORef = new OffenceEO(offenceId,offenceType,penalty,vehType);
        Integer result = offenceDAORef.update(offenceEORef);
        if(result > 0) {
            System.out.println("Record updated successfully");
        }
    }
    
    public void testDeleteOffence() {
        System.out.println("Enter offence Id: ");
        Integer offenceId = sc.nextInt();
      Integer result = offenceDAORef.delete(offenceId);
      if(result > 0) {
          System.out.println("Record Deleted successfully");
      }
    }
    
    public void testSelectByPrimaryKey() {
        System.out.println("Enter offence Id: ");
        Integer offenceId = sc.nextInt();
        OffenceEO  offenceEORef = offenceDAORef.findByOffenceId(offenceId);
        System.out.println(offenceEORef);         
    }
    
    public void testRetrieveOffence() {
        ArrayList<OffenceEO> offences = offenceDAORef.findAllOffence();
        for(OffenceEO offence : offences) {
            System.out.println(offence);
        }    
    }
    
}
