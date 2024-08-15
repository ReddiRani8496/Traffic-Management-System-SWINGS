package tms.dao.impl;

import tms.dao.RegDetailsDAO;

import tms.entities.RegDetailsEO;
import java.sql.*;

import java.util.ArrayList;

import tms.entities.OwnerDetailsEO;
import tms.entities.VehicleDetailsEO;

import tms.util.ResourceManager;

public class RegDetailsDAOImpl implements RegDetailsDAO{
    /** The SQL SELECT All*/
    protected final String SQL_SELECT = "select * from " + getTableName() + "";
    
    /** The SQL INSERT. */
    protected final String SQL_INSERT ="INSERT INTO "+getTableName()+"(APP_NO, VEH_NO, VEH_ID, OWNER_ID, DATE_OF_PURCHASE, DISTRIBUTER_NAME) \n" + 
    "VALUES (?, ?, ?, ?, ?, ?)";
    
    /** The SQL UPDATE */
  protected final String SQL_UPDATE = "update  " + getTableName() + " SET  OWNER_ID = ? WHERE VEH_NO = ?";
    
    /** The SQL Delete */
    protected final String SQL_DELETE = "delete from " + getTableName() + " where  VEH_NO = ?";
    
    /** SQL select based on primary key */
    protected final String SQL_SELECT_BY_PRIMARY_KEY = "select * from " + getTableName() + " where VEH_NO = ?";
    
    
    
    
    public String getTableName() {
        return "REGDETAILS";
    }
    
    public Integer add(RegDetailsEO regDetailsEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
            pstmt.setInt(1, regDetailsEORef.getAppNo());
            pstmt.setString(2, regDetailsEORef.getVehNo());
            pstmt.setInt(3, regDetailsEORef.getVehicleDetails().getVehId());
            pstmt.setInt(4, regDetailsEORef.getOwnerDetails().getOwnerId());
            pstmt.setDate(5, regDetailsEORef.getDateOfPurchase());
            pstmt.setString(6, regDetailsEORef.getDistributerName());
            
            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(pstmt);
            ResourceManager.close(con);
        }
        return result;
    }
    
    public Integer update(RegDetailsEO regDetailsEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
            pstmt.setInt(1, regDetailsEORef.getOwnerDetails().getOwnerId());
            pstmt.setString(2, regDetailsEORef.getVehNo());
            System.out.println( regDetailsEORef.getOwnerDetails().getOwnerId() + " " + regDetailsEORef.getVehNo());
            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(pstmt);
            ResourceManager.close(con);
        }
        return result;
    }
    
    public Integer delete(String vehNo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setString(1, vehNo);
            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(pstmt);
            ResourceManager.close(con);
        }
        return result;
    }

    public RegDetailsEO findByVehNo(String vehNo) {
        Connection con = null;
        PreparedStatement pstmt = null;
        RegDetailsEO regDetailsEORef = null;
        VehicleDetailsEO vehicle = new VehicleDetailsEO();
        OwnerDetailsEO owner = new OwnerDetailsEO();
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_PRIMARY_KEY);
            pstmt.setString(1, vehNo);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                regDetailsEORef = new RegDetailsEO();
                regDetailsEORef.setAppNo(res.getInt(1));
                regDetailsEORef.setVehNo(res.getString(2));
                vehicle.setVehId(res.getInt(3));
                regDetailsEORef.setVehicleDetails(vehicle);
                owner.setOwnerId(res.getInt(4));
                regDetailsEORef.setOwnerDetails(owner);
                regDetailsEORef.setDateOfPurchase(res.getDate(5));
                regDetailsEORef.setDistributerName(res.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(pstmt);
            ResourceManager.close(con);
        }
        return regDetailsEORef;
    }
    
    public ArrayList<RegDetailsEO> findAllRegDetails() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        ArrayList<RegDetailsEO> list = new ArrayList<>();
       
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
            res = pstmt.executeQuery();
            while (res.next()) {
                RegDetailsEO regDetailsEORef = new RegDetailsEO();
                VehicleDetailsEO vehicle = new VehicleDetailsEO();
                OwnerDetailsEO owner = new OwnerDetailsEO();
                
                regDetailsEORef.setAppNo(res.getInt(1));
                regDetailsEORef.setVehNo(res.getString(2));
                vehicle.setVehId(res.getInt(3));
                regDetailsEORef.setVehicleDetails(vehicle);
                owner.setOwnerId(res.getInt(4));
                regDetailsEORef.setOwnerDetails(owner);
                regDetailsEORef.setDateOfPurchase(res.getDate(5));
                regDetailsEORef.setDistributerName(res.getString(6));
                list.add(regDetailsEORef);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(res);
            ResourceManager.close(pstmt);
            ResourceManager.close(con);
        }
        return list;
    }



}
