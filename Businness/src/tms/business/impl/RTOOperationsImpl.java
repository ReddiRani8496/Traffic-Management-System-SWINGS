package tms.business.impl;

import java.io.File;

import java.io.FileWriter;

import java.util.ArrayList;

import tms.business.RTOOperations;

import tms.dao.OffenceDAO;
import tms.dao.OffenceDetailsDAO;
import tms.dao.OwnerDetailsDAO;
import tms.dao.RegDetailsDAO;
import tms.dao.VehicleDetailsDAO;

import tms.entities.OffenceDetailsEO;
import tms.entities.OffenceEO;
import tms.entities.OwnerDetailsEO;
import tms.entities.RegDetailsEO;
import tms.entities.VehicleDetailsEO;

import tms.factory.OffenceDAOFactory;
import tms.factory.OffenceDetailsDAOFactory;
import tms.factory.OwnerDetailsDAOFactory;
import tms.factory.RegDetailsDAOFactory;
import tms.factory.VehicleDetailsDAOFactory;

import tms.test.VehicleDetailsDAOTest;

public class RTOOperationsImpl implements RTOOperations{
    
    private VehicleDetailsDAO vehicleDAORef = VehicleDetailsDAOFactory.createVehicleDetailsDAO();
    private OwnerDetailsDAO ownerDAORef = OwnerDetailsDAOFactory.createOwnerDAO();
     public OffenceDAO offenceDAORef = OffenceDAOFactory.createOffenceDAO();
    private RegDetailsDAO regDetailsDAORef = RegDetailsDAOFactory.createRegDetailsDAO();
    public OffenceDetailsDAO offenceDetailsDAORef = OffenceDetailsDAOFactory.createOffenceDetailsDAO();
    
    public Integer addNewVehicle(VehicleDetailsEO vehicleEORef) {
        return vehicleDAORef.add(vehicleEORef);
    }

    public Integer updateVehicle(VehicleDetailsEO vehicleEORef) {
        return vehicleDAORef.update(vehicleEORef);
    }

    public Integer deleteVehicle(String vehNo) {
        RegDetailsEO regDetails = regDetailsDAORef.findByVehNo(vehNo);
        Integer vehicleId = regDetails.getVehicleDetails().getVehId();
        return vehicleDAORef.delete(vehicleId);
    }
    
    public VehicleDetailsEO fetchVehiclesById(String vehNo) {
        RegDetailsEO regDetails = regDetailsDAORef.findByVehNo(vehNo);
        
        Integer vehicleId = regDetails.getVehicleDetails().getVehId();
        VehicleDetailsEO vehicle = vehicleDAORef.findByVehId(vehicleId);
        
        return vehicle;
    }
  

    public ArrayList<VehicleDetailsEO> fetchAllVehicles() {
        return vehicleDAORef.findAllVehicleDetails();
    }
    
    // owner 
    
    public Integer addNewOwner(OwnerDetailsEO ownerDetailsEORef) {
        return ownerDAORef.add(ownerDetailsEORef);
    }

    public Integer updateOwner(OwnerDetailsEO ownerDetailsEORef) {
        return  ownerDAORef.update(ownerDetailsEORef);
    }

    public Integer deleteOwner(String vehNo) {
        RegDetailsEO regDetails = regDetailsDAORef.findByVehNo(vehNo);
        Integer ownerId = regDetails.getOwnerDetails().getOwnerId();
        return ownerDAORef.delete(ownerId);
    }

    public OwnerDetailsEO fetchOwnersById(String panNum) {
       
        return ownerDAORef.findByOwnerId(panNum);
    }

    public ArrayList<OwnerDetailsEO> fetchAllOwners() {
        return ownerDAORef.findAllOwners();
    }
    
    // offence

    public Integer addOffence(OffenceEO offenceEORef) {
        return offenceDAORef.add(offenceEORef);
    }

    public Integer updateOffence(OffenceEO offenceEORef) {
        return offenceDAORef.update(offenceEORef);
    }

    public Integer deleteOffence(Integer offenceId) {
        return offenceDAORef.delete(offenceId);
    }

    public OffenceEO fetchOffencesById(Integer offenceId) {
        return offenceDAORef.findByOffenceId(offenceId);
    }

    public ArrayList<OffenceEO> fetchAllOffences() {
        return offenceDAORef.findAllOffence();
    }

    public Integer registerVehicle(RegDetailsEO regDetailsEORef) {
        return regDetailsDAORef.add(regDetailsEORef);
    }

    
    public Integer transferVehicle(RegDetailsEO regDetailsEORef) {
        System.out.println(regDetailsEORef);
        return regDetailsDAORef.update(regDetailsEORef);
    }


    public ArrayList<RegDetailsEO> registrationDetails() {
        return regDetailsDAORef.findAllRegDetails();
    }
    public RegDetailsEO findRegstrationById(String vehNum) {
        return regDetailsDAORef.findByVehNo(vehNum);
    }


    public OwnerDetailsEO findByOwner(Integer ownerId) {
        return ownerDAORef.findByOwner(ownerId);
    }

    public ArrayList<OffenceDetailsEO> findOffenceDetails(String vehNum) {
        return offenceDetailsDAORef.findAllOffenceDetailsByVehNum(vehNum);
    }
}
