package tms.business.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tms.business.TCopOperations;

import tms.dao.OffenceDetailsDAO;

import tms.dao.OwnerDetailsDAO;
import tms.dao.RegDetailsDAO;

import tms.dao.VehicleDetailsDAO;

import tms.entities.OffenceDetailsEO;

import tms.entities.OwnerDetailsEO;
import tms.entities.RegDetailsEO;
import tms.entities.VehicleDetailsEO;

import tms.factory.OffenceDetailsDAOFactory;
import tms.factory.OwnerDetailsDAOFactory;
import tms.factory.RegDetailsDAOFactory;
import tms.factory.VehicleDetailsDAOFactory;

public class TCopOperationsImpl implements TCopOperations {
    
    private OffenceDetailsDAO offenceDetailsDaoRef = OffenceDetailsDAOFactory.createOffenceDetailsDAO();
    private RegDetailsDAO regDetailsDAORef = RegDetailsDAOFactory.createRegDetailsDAO();
    private VehicleDetailsDAO vehicleDAORef = VehicleDetailsDAOFactory.createVehicleDetailsDAO();
    private OwnerDetailsDAO ownerDAORef = OwnerDetailsDAOFactory.createOwnerDAO();
    private OffenceDetailsDAO offenceDetailsDAORef = OffenceDetailsDAOFactory.createOffenceDetailsDAO();
    
    public Integer raiseOffence(OffenceDetailsEO offenceDetailsRef) {
        return offenceDetailsDaoRef.add(offenceDetailsRef);
    }

    public Integer clearOffence(OffenceDetailsEO offenceDetailsRef) {
        return offenceDetailsDaoRef.update(offenceDetailsRef);
    }

    public VehicleDetailsEO fetchVehicleDetails(String vehNo) {
        
        RegDetailsEO regDetails = regDetailsDAORef.findByVehNo(vehNo);
        
        Integer vehicleId = regDetails.getVehicleDetails().getVehId();
        VehicleDetailsEO vehicle = vehicleDAORef.findByVehId(vehicleId);
        
        return vehicle;
    }

    public OwnerDetailsEO fetchOwnerDetails(String vehNo) {
        
        RegDetailsEO regDetails = regDetailsDAORef.findByVehNo(vehNo);
        
        Integer ownerId = regDetails.getOwnerDetails().getOwnerId();
        OwnerDetailsEO owner = ownerDAORef.findByOwner(ownerId);
        
        return owner;
    }

    public ArrayList<OffenceDetailsEO> fetchAllOffencesCommited(String vehNo) {
        ArrayList<OffenceDetailsEO> offenceDetails = offenceDetailsDAORef.findAllOffenceDetails();
        
        ArrayList<OffenceDetailsEO> updatedOffenceDet = new ArrayList<OffenceDetailsEO>();
  
        for (OffenceDetailsEO detail : offenceDetails) {
            String vehicleNumber = detail.getRegDetails().getVehNo();
            
            if(vehNo.equals(vehicleNumber))
                    updatedOffenceDet.add(detail);
        }
        
        return updatedOffenceDet;
        
    }
    
    public static void main(String[] args) {
        TCopOperationsImpl copOperations = new TCopOperationsImpl();

//            ArrayList<OffenceDetailsEO> offences = copOperations.fetchAllOffencesCommited("ABC123");
//            
//            for (OffenceDetailsEO offenceDetails : offences) {
//                System.out.println(offenceDetails);
//        }
        String vehicleNumber = "ABC123";
//        VehicleDetailsEO vehicleDetails = copOperations.fetchVehicleDetails(vehicleNumber);
//        System.out.println( vehicleDetails);
        OwnerDetailsEO owner = copOperations.fetchOwnerDetails(vehicleNumber);
        System.out.println(owner);
            
    }
    
}
