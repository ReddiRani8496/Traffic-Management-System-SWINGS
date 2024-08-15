package tms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import tms.dao.VehicleDetailsDAO;

import tms.entities.OwnerDetailsEO;
import tms.entities.UserMasterEO;

import tms.entities.VehicleDetailsEO;

import tms.util.ResourceManager;

public class VehicleDetailsDAOImpl implements VehicleDetailsDAO{
    /** The SQL SELECT All*/
    protected final String SQL_SELECT = "select * from " + getTableName() + "";
    
    /** The SQL INSERT. */
    protected final String SQL_INSERT ="INSERT INTO "+getTableName()+"(VEH_ID, VEH_TYPE, ENGINE_NO, MODEL_NO, VEH_NAME, VEH_COLOR, MANUFACTURER_NAME, DATE_OF_MANUFACTURE, NO_OF_CYLINDERS, CUBIC_CAPACITY, FUEL_USED, CHASSIS_NO) \n" + 
    " VALUES (veh_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    /** The SQL UPDATE */
    protected final String SQL_UPDATE = "update  " + getTableName() + " SET  VEH_COLOR = ?" + " WHERE VEH_ID = ?";
    
    /** The SQL Delete */
    protected final String SQL_DELETE = "delete from " + getTableName() + " where veh_id = ?";
    
    /** SQL select based on primary key */
    protected final String SQL_SELECT_BY_PRIMARY_KEY = "select * from " + getTableName() + " where veh_id = ?";
    
    public String getTableName() {
        return "VEHICLEDETAILS";
    }
    
    public Integer add(VehicleDetailsEO vehicleDetailsEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_INSERT);
//            pstmt.setInt(1, vehicleDetailsEORef.getVehId());
            pstmt.setString(1, vehicleDetailsEORef.getVehType());
            pstmt.setString(2, vehicleDetailsEORef.getEngineNo());
            pstmt.setString(3, vehicleDetailsEORef.getModelNo());
            pstmt.setString(4, vehicleDetailsEORef.getVehName());
            pstmt.setString(5, vehicleDetailsEORef.getVehColor());
            pstmt.setString(6, vehicleDetailsEORef.getManufacturerName());
            pstmt.setDate(7,vehicleDetailsEORef.getDateOfManufacture());
            pstmt.setInt(8, vehicleDetailsEORef.getNoOfCylinders());
            pstmt.setInt(9, vehicleDetailsEORef.getCubicCapacity());
            pstmt.setString(10, vehicleDetailsEORef.getFuelUsed());
            pstmt.setString(11, vehicleDetailsEORef.getChassisNo());
            
             result = pstmt.executeUpdate();
                } catch(SQLException e) {
                    e.printStackTrace();
                } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
        } 
    
    public Integer update(VehicleDetailsEO vehicleDetailsEORef) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con = ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE);
           
            pstmt.setString(1, vehicleDetailsEORef.getVehColor());
            pstmt.setInt(2, vehicleDetailsEORef.getVehId());
            
            result = pstmt.executeUpdate();
            
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    } 
    
    public Integer delete(Integer vehId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_DELETE);
            pstmt.setInt(1, vehId);
           result = pstmt.executeUpdate();
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                   ResourceManager.close(pstmt);
                    ResourceManager.close(con);
                 }
        return result;
    }
    
    public VehicleDetailsEO findByVehId(Integer vehId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        VehicleDetailsEO vehicleDetailsEORef = null;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT_BY_PRIMARY_KEY);
            pstmt.setInt(1, vehId);
           ResultSet res = pstmt.executeQuery();
            // process the result set
            while(res.next()) {
                vehicleDetailsEORef = new VehicleDetailsEO();
                vehicleDetailsEORef.setVehId(res.getInt(1));
                vehicleDetailsEORef.setVehType(res.getString(1));
                vehicleDetailsEORef.setEngineNo(res.getString(3));
                vehicleDetailsEORef.setModelNo(res.getString(4));
                vehicleDetailsEORef.setVehName(res.getString(5));
                vehicleDetailsEORef.setVehColor(res.getString(6));
                vehicleDetailsEORef.setManufacturerName(res.getString(7));
                vehicleDetailsEORef.setDateOfManufacture(res.getDate(8));
                vehicleDetailsEORef.setNoOfCylinders(res.getInt(9));
                vehicleDetailsEORef.setCubicCapacity(res.getInt(10));
                vehicleDetailsEORef.setFuelUsed(res.getString(11));
                vehicleDetailsEORef.setChassisNo(res.getString(12));
                
            }
        } catch(SQLException e) {
                    e.printStackTrace();
            } finally {
                ResourceManager.close(pstmt);
                ResourceManager.close(con);
            }
        return vehicleDetailsEORef;
    }
    
    public ArrayList<VehicleDetailsEO> findAllVehicleDetails() {
        Connection con = null;
        PreparedStatement pstmt = null;
       
        ArrayList<VehicleDetailsEO> list = new ArrayList<VehicleDetailsEO>();
        ResultSet res = null;
        try {
            con =  ResourceManager.getConnection();
            pstmt = con.prepareStatement(SQL_SELECT);
          
           res = pstmt.executeQuery();
            while(res.next()) {
                VehicleDetailsEO vehicleDetailsEORef = new VehicleDetailsEO();
                vehicleDetailsEORef.setVehId(res.getInt(1));
                vehicleDetailsEORef.setVehType(res.getString(1));
                vehicleDetailsEORef.setEngineNo(res.getString(3));
                vehicleDetailsEORef.setModelNo(res.getString(4));
                vehicleDetailsEORef.setVehName(res.getString(5));
                vehicleDetailsEORef.setVehColor(res.getString(6));
                vehicleDetailsEORef.setManufacturerName(res.getString(7));
                vehicleDetailsEORef.setDateOfManufacture(res.getDate(8));
                vehicleDetailsEORef.setNoOfCylinders(res.getInt(9));
                vehicleDetailsEORef.setCubicCapacity(res.getInt(10));
                vehicleDetailsEORef.setFuelUsed(res.getString(11));
                vehicleDetailsEORef.setChassisNo(res.getString(12));
                
                list.add(vehicleDetailsEORef);
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
