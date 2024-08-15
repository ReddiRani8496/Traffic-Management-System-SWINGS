package tms.dao.impl;

import java.util.ArrayList;

import tms.dao.OffenceDetailsDAO;
import tms.entities.OffenceDetailsEO;

import java.sql.*;

import java.sql.Timestamp;

import tms.entities.OffenceEO;
import tms.entities.RegDetailsEO;

import tms.entities.UserMasterEO;

import tms.util.ResourceManager;

public class OffenceDetailsDAOImpl implements OffenceDetailsDAO{
    /** The SQL SELECT All*/
    protected final String SQL_SELECT = "select * from " + getTableName() + "";
    
    /** The SQL INSERT. */
    protected final String SQL_INSERT ="INSERT INTO "+getTableName()+"(VEH_NO, IMAGE, OFFENCE_DETAIL_ID, OFFENCE_STATUS, OFFENCE_ID, TIME, PLACE, REPORTED_BY) VALUES (?, ?, offence_detail_id_seq.nextval, ?, ?, ?, ?, ?)";
    
    /** The SQL UPDATE */
    protected final String SQL_UPDATE = "update  " + getTableName() + " SET  OFFENCE_STATUS = ? WHERE OFFENCE_DETAIL_ID = ?";
    
    /** The SQL Delete */
    protected final String SQL_DELETE = "delete from " + getTableName() + " where OFFENCE_DETAIL_ID = ?";
    
    /** SQL select based on primary key */
    protected final String SQL_SELECT_BY_PRIMARY_KEY = "select * from " + getTableName() + " where OFFENCE_DETAIL_ID = ?";
    
    protected final String SQL_SELECT_BY_Veh_Num = "select * from " + getTableName() + " where VEH_NO = ?";
    
    public String getTableName() {
        return "OFFENCE_DETAILS";
    }
    
    public Integer add(OffenceDetailsEO offenceDetailsEORef) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setString(1, offenceDetailsEORef.getRegDetails().getVehNo());
            pstmt.setBytes(2, offenceDetailsEORef.getImage());
//            pstmt.setInt(3, offenceDetailsEORef.getOffenceDetailId());
            pstmt.setString(3, offenceDetailsEORef.getOffenceStatus());
            pstmt.setInt(4, offenceDetailsEORef.getOffence().getOffenceId());
            pstmt.setTimestamp(5,offenceDetailsEORef.getTime()); 
            pstmt.setString(6, offenceDetailsEORef.getPlace());
            pstmt.setString(7, offenceDetailsEORef.getUser().getUsername());
            
            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(pstmt);
            ResourceManager.close(con);
        }
        return result;
    }
    
    public Integer update(OffenceDetailsEO offenceDetailsEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setString(1, "Paid");
            pstmt.setInt(2, offenceDetailsEORef.getOffenceDetailId());
            
            result = pstmt.executeUpdate();
            
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    } 
    
    public Integer delete(Integer offenceDetailId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, offenceDetailId);
           result = pstmt.executeUpdate();
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    }
    
    public OffenceDetailsEO findByOffenceDetailId(Integer offenceDetailId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        OffenceDetailsEO offenceDetailsEORef = null;
        RegDetailsEO regDetails = new RegDetailsEO();
        OffenceEO offence = new OffenceEO();
        UserMasterEO user = new UserMasterEO();
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_PRIMARY_KEY);
            pstmt.setInt(1, offenceDetailId);
            ResultSet res = pstmt.executeQuery();
            
            if (res.next()) {
                offenceDetailsEORef = new OffenceDetailsEO();
                regDetails.setVehNo(res.getString(1));
                offenceDetailsEORef.setRegDetails(regDetails);
                
                offenceDetailsEORef.setImage(res.getBytes(2));
                offenceDetailsEORef.setOffenceDetailId(res.getInt(3));
                offenceDetailsEORef.setOffenceStatus(res.getString(4));
                
                offence.setOffenceId(res.getInt(5));
                offenceDetailsEORef.setOffence(offence);
                
                offenceDetailsEORef.setTime(res.getTimestamp(6));
                offenceDetailsEORef.setPlace(res.getString(7));
                
                user.setUsername(res.getString(8));
                offenceDetailsEORef.setUser(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(pstmt);
            ResourceManager.close(con);
        }
        return offenceDetailsEORef;
    }


    public ArrayList<OffenceDetailsEO> findAllOffenceDetails() {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        ArrayList<OffenceDetailsEO> list = new ArrayList<OffenceDetailsEO>();
        ResultSet res = null;
        
        
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
          
           res = pstmt.executeQuery();
            while(res.next()) {
                OffenceDetailsEO offenceDetailsEORef = new OffenceDetailsEO();
                RegDetailsEO regDetails = new RegDetailsEO();
                OffenceEO offence = new OffenceEO();
                UserMasterEO user = new UserMasterEO();
                
                regDetails.setVehNo(res.getString(1));
                offenceDetailsEORef.setRegDetails(regDetails);
//                System.out.println(regDetails.getVehNo());
                offenceDetailsEORef.setImage(res.getBytes(2));
                offenceDetailsEORef.setOffenceDetailId(res.getInt(3));
                offenceDetailsEORef.setOffenceStatus(res.getString(4));
                
                offence.setOffenceId(res.getInt(5));
                offenceDetailsEORef.setOffence(offence);
                
                offenceDetailsEORef.setTime(res.getTimestamp(6));
                offenceDetailsEORef.setPlace(res.getString(7));
                
                user.setUsername(res.getString(8));
                offenceDetailsEORef.setUser(user);
                
                list.add(offenceDetailsEORef);
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

    public ArrayList<OffenceDetailsEO> findAllOffenceDetailsByVehNum(String vehNum) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ArrayList<OffenceDetailsEO> list = new ArrayList<OffenceDetailsEO>();
        ResultSet res = null;
        
        
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_Veh_Num);
          pstmt.setString(1, vehNum);
           res = pstmt.executeQuery();
            while(res.next()) {
                OffenceDetailsEO offenceDetailsEORef = new OffenceDetailsEO();
                RegDetailsEO regDetails = new RegDetailsEO();
                OffenceEO offence = new OffenceEO();
                UserMasterEO user = new UserMasterEO();
                
                regDetails.setVehNo(res.getString(1));
                offenceDetailsEORef.setRegDetails(regDetails);
        //                System.out.println(regDetails.getVehNo());
                offenceDetailsEORef.setImage(res.getBytes(2));
                offenceDetailsEORef.setOffenceDetailId(res.getInt(3));
                offenceDetailsEORef.setOffenceStatus(res.getString(4));
                
                offence.setOffenceId(res.getInt(5));
                offenceDetailsEORef.setOffence(offence);
                
                offenceDetailsEORef.setTime(res.getTimestamp(6));
                offenceDetailsEORef.setPlace(res.getString(7));
                
                user.setUsername(res.getString(8));
                offenceDetailsEORef.setUser(user);
                
                list.add(offenceDetailsEORef);
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
