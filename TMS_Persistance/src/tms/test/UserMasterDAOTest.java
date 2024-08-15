package tms.test;

import java.util.ArrayList;
import java.util.Scanner;


import tms.dao.UserMasterDAO;

import tms.entities.RoleMasterEO;
import tms.entities.UserMasterEO;

import tms.factory.UserMasterDAOFactory;

public class UserMasterDAOTest {
    public UserMasterDAO userMasterDAORef = UserMasterDAOFactory.createUserMasterDAO();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        UserMasterDAOTest userRef = new UserMasterDAOTest();
        //userRef.testCreateUserMaster();
      //userRef.testUpdateUserMaster();
        userRef.testdeleteUserMaster();
     //   userRef.testRetrieveUsers();
      //  userRef.testLogin();
    }
    
    public void testCreateUserMaster() {
        
        System.out.println("Enter user name: ");
        String userName = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        
        System.out.println("Enter role name:");
        RoleMasterEO role = new RoleMasterEO();
        role.setRoleName(sc.nextLine());
        
        UserMasterEO userMasterEORef = new UserMasterEO(userName, password, role);
        Integer result = userMasterDAORef.add(userMasterEORef);
        
        if(result > 0) {
            System.out.println("Record inserted successfully");
        }
    }
    
    public void testUpdateUserMaster() {
        System.out.println("Enter user name: ");
        String userName = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println("Enter role name:");
        RoleMasterEO role = new RoleMasterEO();
        role.setRoleName(sc.nextLine());
        UserMasterEO userMasterEORef = new UserMasterEO(userName, password, role);
        Integer result = userMasterDAORef.update(userMasterEORef);
        
        if(result > 0) {
            System.out.println("Record updated successfully");
        }
    }
    
    public void testdeleteUserMaster() {
        System.out.println("Enter user name: ");
        String userName = sc.nextLine();
        Integer result = userMasterDAORef.delete(userName);
        
        if(result > 0) {
            System.out.println("Record deleted successfully");
        }
    }
    
    public void testSelectByPrimaryKey() {
        System.out.println("Enter user name: ");
        String userName = sc.nextLine();
        UserMasterEO userMasterEO = userMasterDAORef.findByUserName(userName);
        System.out.println(userMasterEO);
    }
    
    public void testRetrieveUsers() {
        ArrayList<UserMasterEO> users = userMasterDAORef.findAllUsers();
        for(UserMasterEO user : users) {
            System.out.println(user);
        }     
    }
    
    public void testLogin() {
        System.out.println("Enter user name: ");
        String userName = sc.nextLine();
        System.out.println("Enter password: ");
        String password = sc.nextLine();
        System.out.println("Enter role name:");
        RoleMasterEO role = new RoleMasterEO();
        role.setRoleName(sc.nextLine());
        UserMasterEO userMasterEORef = new UserMasterEO(userName, password, role);
        System.out.println(userMasterDAORef.login(userMasterEORef));
        
    }
    
}
