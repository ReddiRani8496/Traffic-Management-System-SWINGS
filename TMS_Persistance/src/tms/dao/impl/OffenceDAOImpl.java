package tms.dao.impl;

import tms.dao.OffenceDAO;

import tms.entities.OffenceEO;

import java.sql.*;


import java.util.ArrayList;

import tms.util.ResourceManager;

public class OffenceDAOImpl implements OffenceDAO{
    /** The SQL SELECT All*/
    protected final String SQL_SELECT = "select * from " + getTableName() + "";
    
    /** The SQL INSERT. */
    protected final String SQL_INSERT ="INSERT INTO "+getTableName()+"(OFFENCE_ID, OFFENCE_TYPE, PENALTY, VEH_TYPE) VALUES (offence_id_seq.nextval,?, ?, ?)";
    
    /** The SQL UPDATE */
    protected final String SQL_UPDATE = "update  " + getTableName() + " SET  PENALTY = ?, VEH_TYPE = ? WHERE OFFENCE_ID = ?";
    
    /** The SQL Delete */
    protected final String SQL_DELETE = "delete from " + getTableName() + " where OFFENCE_ID = ?";
    
    /** SQL select based on primary key */
    protected final String SQL_SELECT_BY_PRIMARY_KEY = "select * from " + getTableName() + " where OFFENCE_ID = ?";
    
    public String getTableName() {
        return "offence";
    }
    
    public Integer add(OffenceEO offenceEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
//            pstmt. setInt(1, offence_id_seq.nextval);
            pstmt.setString(1, offenceEORef.getOffenceType());
            pstmt.setInt(2, offenceEORef.getPenalty());
            pstmt.setString(3, offenceEORef.getVehType());
            
             result = pstmt.executeUpdate();
                } catch(SQLException e) {
                    e.printStackTrace();
                } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
        } 
    
    public Integer update(OffenceEO offenceEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, offenceEORef.getPenalty());
            pstmt.setString(2, offenceEORef.getVehType());
            pstmt. setInt(3, offenceEORef.getOffenceId());
            
            result = pstmt.executeUpdate();
            
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    } 
    
    public Integer delete(Integer offenceId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, offenceId);
           result = pstmt.executeUpdate();
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    }
    
    public OffenceEO findByOffenceId(Integer offenceId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        OffenceEO offenceEORef = null;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_PRIMARY_KEY);
            pstmt.setInt(1, offenceId);
           ResultSet res = pstmt.executeQuery();
            // process the result set
            while(res.next()) {
                offenceEORef = new OffenceEO();
                offenceEORef.setOffenceId( res.getInt(1));
                offenceEORef.setOffenceType(res.getString(2));
                offenceEORef.setPenalty (res.getInt(3));
                offenceEORef.setVehType(res.getString(4));
            }
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                ResourceManager.close(pstmt);
                ResourceManager.close(con);
            }
        return offenceEORef;
    }
    
    public ArrayList<OffenceEO> findAllOffence() {
        Connection con = null;
        PreparedStatement pstmt = null;
       
        ArrayList<OffenceEO> list = new ArrayList<OffenceEO>();
        ResultSet res = null;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
          
           res = pstmt.executeQuery();
            while(res.next()) {
                OffenceEO offenceEORef = new OffenceEO();
                offenceEORef.setOffenceId( res.getInt(1));
                offenceEORef.setOffenceType(res.getString(2));
                offenceEORef.setPenalty (res.getInt(3));
                offenceEORef.setVehType(res.getString(4));
                
                list.add(offenceEORef);
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
