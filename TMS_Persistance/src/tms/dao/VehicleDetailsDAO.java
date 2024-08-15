package tms.dao;

import java.util.ArrayList;

import tms.entities.VehicleDetailsEO;

public interface VehicleDetailsDAO {
    
    public Integer add(VehicleDetailsEO vehicleDetailsRef);
    
    public Integer update(VehicleDetailsEO vehicleDetailsRef);
    
    public Integer delete(Integer vehId);
    
    public VehicleDetailsEO findByVehId(Integer vehId);
    
    public ArrayList<VehicleDetailsEO> findAllVehicleDetails();
}
