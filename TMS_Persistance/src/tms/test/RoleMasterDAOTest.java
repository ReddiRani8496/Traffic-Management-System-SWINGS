package tms.test;

import java.util.ArrayList;
import java.util.Scanner;

import tms.dao.RoleMasterDAO;

import tms.entities.RoleMasterEO;

import tms.factory.RoleMasterDAOFactory;

public class RoleMasterDAOTest {
    public RoleMasterDAO roleMasterDAORef = RoleMasterDAOFactory.createRoleMasterDAO();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        RoleMasterDAOTest roleRef = new RoleMasterDAOTest();
        roleRef.testCreateRoleMaster();
       // roleRef.testUpdateRoleMaster();
      //  roleRef.testdeleteRoleMaster();
      //  roleRef.testRetrieveRoles();
      //  roleRef.testSelectByPrimaryKey();
    }
    
    public void testCreateRoleMaster() {
        System.out.println("Enter role name: ");
        String roleName = sc.nextLine();
        System.out.println("Enter role description: ");
        String roleDesc = sc.nextLine();
        RoleMasterEO roleMasterEORef = new RoleMasterEO(roleName, roleDesc);
        Integer result = roleMasterDAORef.add(roleMasterEORef);
        
        if(result > 0) {
            System.out.println("Record inserted successfully");
        }
    }
    
    public void testUpdateRoleMaster() {
        System.out.println("Enter role name: ");
        String roleName = sc.nextLine();
        System.out.println("Enter role description: ");
        String roleDesc = sc.nextLine();
        RoleMasterEO roleMasterEORef = new RoleMasterEO(roleName, roleDesc);
        Integer result = roleMasterDAORef.update(roleMasterEORef);
        
        if(result > 0) {
            System.out.println("Record updated successfully");
        }
    }
    
    public void testdeleteRoleMaster() {
        System.out.println("Enter role name: ");
        String roleName = sc.nextLine();
        Integer result = roleMasterDAORef.delete(roleName);
        
        if(result > 0) {
            System.out.println("Record deleted successfully");
        }
    }
    
    public void testSelectByPrimaryKey() {
        System.out.println("Enter role name: ");
        String roleName = sc.nextLine();
        RoleMasterEO roleMasterEO = roleMasterDAORef.findByRoleName(roleName);
        System.out.println(roleMasterEO);
    }
    
    public void testRetrieveRoles() {
        ArrayList<RoleMasterEO> roles = roleMasterDAORef.findAllRoles();
        for(RoleMasterEO role : roles) {
            System.out.println(role);
        }
        
    }
}
