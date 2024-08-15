package tms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import tms.dao.UserMasterDAO;

import tms.entities.RoleMasterEO;

import tms.entities.UserMasterEO;

import tms.util.ResourceManager;

public class UserMasterDAOImpl implements UserMasterDAO{
    /** The SQL SELECT All*/
    protected final String SQL_SELECT = "select * from " + getTableName() + "";
    
    /** The SQL INSERT. */
    protected final String SQL_INSERT ="INSERT INTO "+getTableName()+"(USERNAME, PASSWORD, ROLENAME) VALUES (?, ?, ?)";;
    
    /** The SQL UPDATE */
    protected final String SQL_UPDATE = "update  " + getTableName() + " SET PASSWORD = ?, ROLENAME=? WHERE USERNAME = ?";
    
    /** The SQL Delete */
    protected final String SQL_DELETE = "delete from " + getTableName() + " WHERE USERNAME = ?";
    
    /** SQL select based on primary key */
    protected final String SQL_SELECT_BY_PRIMARY_KEY = "select * from " + getTableName() + " WHERE USERNAME = ?";
    
    protected final String SQL_Login = "select * from " + getTableName() + " WHERE USERNAME = ? and  PASSWORD = ? and ROLENAME=?";
    
    
    public String getTableName() {
        return "USERMASTER";
    }
    
    public Integer add(UserMasterEO userMasterEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, userMasterEORef.getUsername());
            pstmt.setString(2, userMasterEORef.getPassword());
            pstmt.setString(3, userMasterEORef.getRole().getRoleName());
            
             result = pstmt.executeUpdate();
                } catch(SQLException e) {
                    e.printStackTrace();
                } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
        } 
    
    public Integer update(UserMasterEO userMasterEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
           
            pstmt.setString(1, userMasterEORef.getPassword());
            pstmt.setString(2, userMasterEORef.getRole().getRoleName());
            pstmt.setString(3, userMasterEORef.getUsername());
            
            result = pstmt.executeUpdate();
            
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    } 
    
    public Integer delete(String userName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setString(1, userName);
           result = pstmt.executeUpdate();
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    }
    
    public UserMasterEO findByUserName(String userName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        UserMasterEO userMasterEORef = null;
        RoleMasterEO role = new RoleMasterEO();
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_PRIMARY_KEY);
            pstmt.setString(1, userName);
           ResultSet res = pstmt.executeQuery();
            // process the result set
            while(res.next()) {
                userMasterEORef = new UserMasterEO();
                userMasterEORef.setUsername( res.getString(1));
                userMasterEORef.setPassword(res.getString(2));
//                userMasterEORef.setRole(res.getString(3));
                role.setRoleName(res.getString(3));
                userMasterEORef.setRole(role);                
            }
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                ResourceManager.close(pstmt);
                ResourceManager.close(con);
            }
        return userMasterEORef;
    }
    
    public ArrayList<UserMasterEO> findAllUsers() {
        Connection con = null;
        PreparedStatement pstmt = null;
       
        ArrayList<UserMasterEO> list = new ArrayList<UserMasterEO>();
        ResultSet res = null;
        
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
          
           res = pstmt.executeQuery();
            while(res.next()) {
                UserMasterEO userMasterEORef = new UserMasterEO();
                
                RoleMasterEO role = new RoleMasterEO();
                
                userMasterEORef.setUsername( res.getString(1));
                userMasterEORef.setPassword(res.getString(2));
//                role.setRole(res);
                role.setRoleName(res.getString("rolename"));
                userMasterEORef.setRole(role);
                
                
                list.add(userMasterEORef);
            }
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                ResourceManager.close(res);
                ResourceManager.close(pstmt);
                ResourceManager.close(con);
            }
        return list;
    }

    public boolean login(UserMasterEO user) {
    
        Connection con = null;
        PreparedStatement pstmt = null;
    int rowCount = 0;
        try {
            con =  ResourceManager.getConnection();
            
            pstmt = con.prepareStatement(SQL_Login);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole().getRoleName());
//            System.out.println(user.getUsername());
//            System.out.println(user.getPassword());
//            System.out.println(user.getRole().getRoleName());
           ResultSet res = pstmt.executeQuery();
            
            // process the result set
            while(res.next()) {
                rowCount++;                     
            }
            
            if(rowCount==0) {
                System.out.println("Called");
                return false;
                
            }
          
              
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                ResourceManager.close(pstmt);
                ResourceManager.close(con);
            }
        return true;
    }
}
