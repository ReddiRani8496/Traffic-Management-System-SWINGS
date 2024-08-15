package tms.factory;

import tms.dao.VehicleDetailsDAO;

import tms.dao.impl.VehicleDetailsDAOImpl;

public class VehicleDetailsDAOFactory {
    private static final VehicleDetailsDAO vehicleDetailsDaoRef = new VehicleDetailsDAOImpl();
    public static VehicleDetailsDAO createVehicleDetailsDAO() {
        return vehicleDetailsDaoRef;
    }
}
