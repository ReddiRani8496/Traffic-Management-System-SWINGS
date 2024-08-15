package tms.business.impl;


import java.util.ArrayList;
import java.util.List;

import tms.business.AdminOperations;

import tms.dao.RoleMasterDAO;
import tms.dao.UserMasterDAO;

import tms.entities.RoleMasterEO;
import tms.entities.UserMasterEO;

import tms.factory.RoleMasterDAOFactory;
import tms.factory.UserMasterDAOFactory;

import tms.test.UserMasterDAOTest;

public class AdminOperationsImpl implements AdminOperations {
    
    private UserMasterDAO userMasterDAORef = UserMasterDAOFactory.createUserMasterDAO();
    private RoleMasterDAO roleMasterDAORef = RoleMasterDAOFactory.createRoleMasterDAO();

    public boolean login(UserMasterEO userEORef) {
       return userMasterDAORef.login(userEORef);
    }
    
    public Integer addNewUser(UserMasterEO userEORef) {
        return  userMasterDAORef.add(userEORef);
    }

    public Integer updateUser(UserMasterEO userEORef) {
        return userMasterDAORef.update(userEORef);
    }

    public Integer deleteExisitingUser(String userName) {
        return userMasterDAORef.delete(userName);
    }

    public UserMasterEO findByUserName(String userName) {
        return userMasterDAORef.findByUserName(userName);
    }

    public List<UserMasterEO> fetchAllUsers() {
        return userMasterDAORef.findAllUsers();
    }

    public Integer addNewRole(RoleMasterEO roleEORef) {
        return roleMasterDAORef.add(roleEORef);
    }

    public Integer updateRole(RoleMasterEO roleEORef) {
        return roleMasterDAORef.update(roleEORef);
    }

    public Integer deleteRole(String roleName) {
        return roleMasterDAORef.delete(roleName);
    }

    public RoleMasterEO findByRoleName(String roleName) {
        return roleMasterDAORef.findByRoleName(roleName);
    }

    public List<RoleMasterEO> fetchAllRoles() {
        return roleMasterDAORef.findAllRoles();
    }
    public static void main(String[] args) {
        AdminOperationsImpl admin = new AdminOperationsImpl();
        UserMasterEO user = admin.findByUserName("King");
       System.out.println(user);
    }


}
