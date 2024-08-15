package tms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import tms.dao.RoleMasterDAO;

import tms.entities.OffenceEO;
import tms.entities.RoleMasterEO;

import tms.util.ResourceManager;

public class RoleMasterDAOImpl implements RoleMasterDAO{
    /** The SQL SELECT All*/
    protected final String SQL_SELECT = "select * from " + getTableName() + "";
    
    /** The SQL INSERT. */
    protected final String SQL_INSERT ="INSERT INTO "+getTableName()+"(ROLENAME, ROLE_DESC) VALUES (?, ?)";;
    
    /** The SQL UPDATE */
    protected final String SQL_UPDATE = "update  " + getTableName() + " SET ROLE_DESC = ? WHERE ROLENAME = ?";
    
    /** The SQL Delete */
    protected final String SQL_DELETE = "delete from " + getTableName() + " where ROLENAME = ?";
    
    /** SQL select based on primary key */
    protected final String SQL_SELECT_BY_PRIMARY_KEY = "select * from " + getTableName() + " where ROLENAME = ?";
    
    public String getTableName() {
        return "ROLEMASTER";
    }
    
    public Integer add(RoleMasterEO roleMasterEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt. setString(1,roleMasterEORef.getRoleName());
            pstmt.setString(2, roleMasterEORef.getRoleDesc());
            
             result = pstmt.executeUpdate();
                } catch(SQLException e) {
                    e.printStackTrace();
                } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
        } 
    
    public Integer update(RoleMasterEO roleMasterEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, roleMasterEORef.getRoleDesc());
            pstmt.setString(2, roleMasterEORef.getRoleName());
            
            result = pstmt.executeUpdate();
            
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    } 
    
    public Integer delete(String roleName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setString(1, roleName);
           result = pstmt.executeUpdate();
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    }
    
    public RoleMasterEO findByRoleName(String roleName) {
        Connection con = null;
        PreparedStatement pstmt = null;
        RoleMasterEO roleMasterEORef = null;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_PRIMARY_KEY);
            pstmt.setString(1, roleName);
           ResultSet res = pstmt.executeQuery();
            // process the result set
            while(res.next()) {
                roleMasterEORef = new RoleMasterEO();
                roleMasterEORef.setRoleName( res.getString(1));
                roleMasterEORef.setRoleDesc(res.getString(2));
                
            }
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                ResourceManager.close(pstmt);
                ResourceManager.close(con);
            }
        return roleMasterEORef;
    }
    
    public ArrayList<RoleMasterEO> findAllRoles() {
        Connection con = null;
        PreparedStatement pstmt = null;
       
        ArrayList<RoleMasterEO> list = new ArrayList<RoleMasterEO>();
        ResultSet res = null;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
          
           res = pstmt.executeQuery();
            while(res.next()) {
                RoleMasterEO roleMasterEORef = new RoleMasterEO();
                roleMasterEORef.setRoleName( res.getString(1));
                roleMasterEORef.setRoleDesc(res.getString(2));
                
                list.add(roleMasterEORef);
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
}
