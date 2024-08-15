package tms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;


import tms.dao.OwnerDetailsDAO;

import tms.entities.OwnerDetailsEO;

import tms.util.ResourceManager;

public class OwnerDetailsDAOImpl implements OwnerDetailsDAO{
    /** The SQL SELECT All*/
    protected final String SQL_SELECT = "select * from " + getTableName() + "";
    
    /** The SQL INSERT. */
    protected final String SQL_INSERT ="INSERT INTO "+getTableName()+"(OWNER_ID, FNAME, LNAME, DATEOFBIRTH, LANDLINE_NO, MOBILE_NO, GENDER, TEMP_ADDR, PERM_ADDR, PINCODE, OCCUPATION, PANCARD_ID, ADD_PROOF_NAME)" +
        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    /** The SQL UPDATE */
    protected final String SQL_UPDATE = "update  " + getTableName() + " SET  LANDLINE_NO = ?, MOBILE_NO = ?,  TEMP_ADDR = ?,  PINCODE = ?, OCCUPATION = ? WHERE  OWNER_ID= ?";
    
    /** The SQL Delete */
    protected final String SQL_DELETE = "delete from " + getTableName() + " where OWNER_ID = ?";
    
    /** SQL select based on primary key */
    protected final String SQL_SELECT_BY_PRIMARY_KEY = "select * from " + getTableName() + " where PANCARD_ID = ?";
    protected final String SQL_SELECT_BY_OwnerId = "select * from " + getTableName() + " where OWNER_ID = ?";
    
    public String getTableName() {
        return "OWNERDETAILS";
    }
    
    public Integer add(OwnerDetailsEO ownerDetailsEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt. setInt(1,ownerDetailsEORef.getOwnerId());
            pstmt.setString(2, ownerDetailsEORef.getFName());
            pstmt.setString(3, ownerDetailsEORef.getLName());
           pstmt.setDate(4, ownerDetailsEORef.getDateOfBirth());
            pstmt.setString(5, ownerDetailsEORef.getLandLineNo());
            pstmt.setString(6, ownerDetailsEORef.getMobileNo());
            pstmt.setString(7, String.valueOf(ownerDetailsEORef.getGender()));
            pstmt.setString(8, ownerDetailsEORef.getTempAddr());
            pstmt.setString(9,ownerDetailsEORef.getPermAddr());
            pstmt.setInt(10, ownerDetailsEORef.getPincode());
            pstmt.setString(11, ownerDetailsEORef.getOccupation());
            pstmt.setString(12, ownerDetailsEORef.getPanCardId());
            pstmt.setString(13, ownerDetailsEORef.getAddProofName());
             result = pstmt.executeUpdate();
                } catch(SQLException e) {
                    e.printStackTrace();
                } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
        } 
        
    public Integer update(OwnerDetailsEO ownerDetailsEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            
            pstmt.setString(1, ownerDetailsEORef.getLandLineNo());
            pstmt.setString(2, ownerDetailsEORef.getMobileNo());
            pstmt.setString(3, ownerDetailsEORef.getTempAddr());
            pstmt.setInt(4, ownerDetailsEORef.getPincode());
            pstmt.setString(5, ownerDetailsEORef.getOccupation());
            pstmt. setInt(6,ownerDetailsEORef.getOwnerId());
            result = pstmt.executeUpdate();
            
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    }
    
    public Integer delete(Integer ownerId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, ownerId);
           result = pstmt.executeUpdate();
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    }
    public OwnerDetailsEO findByOwnerId(String panNum) {
        Connection con = null;
        PreparedStatement pstmt = null;
        OwnerDetailsEO ownerEORef = null;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_PRIMARY_KEY);
            pstmt.setString(1, panNum);
           ResultSet res = pstmt.executeQuery();
            // process the result set
            while(res.next()) {
                ownerEORef = new OwnerDetailsEO();
                ownerEORef.setOwnerId( res.getInt(1));
                ownerEORef.setFName(res.getString(2));
                ownerEORef.setLName (res.getString(3));
                ownerEORef.setDateOfBirth(res.getDate(4));
                ownerEORef.setLandLineNo(res.getString(5));
                ownerEORef.setMobileNo(res.getString(6));
            
                ownerEORef.setGender(res.getString(7));
                ownerEORef.setTempAddr(res.getString(8));
                ownerEORef.setPermAddr(res.getString(9));
                ownerEORef.setPincode(res.getInt(10));
                ownerEORef.setOccupation(res.getString(11));
                ownerEORef.setPanCardId(res.getString(12));
                ownerEORef.setAddProofName(res.getString(13));
            }
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                ResourceManager.close(pstmt);
                ResourceManager.close(con);
            }
        return ownerEORef;
    }
    
    public ArrayList<OwnerDetailsEO> findAllOwners() {
        Connection con = null;
        PreparedStatement pstmt = null;
       
        ArrayList<OwnerDetailsEO> list = new ArrayList<OwnerDetailsEO>();
        ResultSet res = null;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
          
           res = pstmt.executeQuery();
            while(res.next()) {
                OwnerDetailsEO ownerEORef = new OwnerDetailsEO();
                ownerEORef.setOwnerId( res.getInt(1));
                ownerEORef.setFName(res.getString(2));
                ownerEORef.setLName (res.getString(3));
                ownerEORef.setDateOfBirth(res.getDate(4));
                ownerEORef.setLandLineNo(res.getString(5));
                ownerEORef.setMobileNo(res.getString(6));
                
                ownerEORef.setGender( res.getString(7));
                ownerEORef.setTempAddr(res.getString(8));
                ownerEORef.setPermAddr(res.getString(9));
                ownerEORef.setPincode(res.getInt(10));
                ownerEORef.setOccupation(res.getString(11));
                ownerEORef.setPanCardId(res.getString(12));
                ownerEORef.setAddProofName(res.getString(13));
                
                list.add(ownerEORef);
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


    public OwnerDetailsEO findByOwner(Integer ownerId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        OwnerDetailsEO ownerEORef = null;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_OwnerId);
            pstmt.setInt(1, ownerId);
           ResultSet res = pstmt.executeQuery();
            // process the result set
            while(res.next()) {
                ownerEORef = new OwnerDetailsEO();
                ownerEORef.setOwnerId( res.getInt(1));
                ownerEORef.setFName(res.getString(2));
                ownerEORef.setLName (res.getString(3));
                ownerEORef.setDateOfBirth(res.getDate(4));
                ownerEORef.setLandLineNo(res.getString(5));
                ownerEORef.setMobileNo(res.getString(6));
            
                ownerEORef.setGender(res.getString(7));
                ownerEORef.setTempAddr(res.getString(8));
                ownerEORef.setPermAddr(res.getString(9));
                ownerEORef.setPincode(res.getInt(10));
                ownerEORef.setOccupation(res.getString(11));
                ownerEORef.setPanCardId(res.getString(12));
                ownerEORef.setAddProofName(res.getString(13));
            }
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                ResourceManager.close(pstmt);
                ResourceManager.close(con);
            }
        return ownerEORef;
    }
}
