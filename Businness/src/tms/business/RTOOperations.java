package tms.business;

import java.io.File;

import java.util.ArrayList;

import tms.entities.OffenceDetailsEO;
import tms.entities.OffenceEO;
import tms.entities.OwnerDetailsEO;
import tms.entities.RegDetailsEO;
import tms.entities.VehicleDetailsEO;


public interface RTOOperations {
    
    // Managing vehicles
    public Integer addNewVehicle(VehicleDetailsEO vehicleEORef);
    
    public Integer updateVehicle(VehicleDetailsEO vehicleEORef);
    
    public Integer deleteVehicle(String vehNo);
    
    public VehicleDetailsEO fetchVehiclesById(String vehNo);
    
    public ArrayList<VehicleDetailsEO> fetchAllVehicles();
    
    // Managing Owner Details
    public Integer addNewOwner(OwnerDetailsEO ownerDetailsEORef);
    
    public Integer updateOwner(OwnerDetailsEO ownerDetailsEORef);
    
    public Integer deleteOwner(String vehNo);
    
    public OwnerDetailsEO fetchOwnersById(String panNum);
    
    public ArrayList<OwnerDetailsEO> fetchAllOwners();
    
    public OwnerDetailsEO  findByOwner(Integer ownerId);
    
    // Managing Offence types
    public Integer addOffence(OffenceEO offenceEORef);
    
    public Integer updateOffence(OffenceEO offenceEORef);
    
    public Integer deleteOffence(Integer offenceId);
    
    public OffenceEO fetchOffencesById(Integer offenceId);
    
    public ArrayList<OffenceEO> fetchAllOffences();
    
    // transfer vehicle
    
    public Integer registerVehicle(RegDetailsEO regDetailsEORef);
    
    public Integer transferVehicle(RegDetailsEO regDetailsEORef);
    
    public ArrayList<RegDetailsEO> registrationDetails();
    
    public RegDetailsEO findRegstrationById(String vehNum);
    
//    public File reportGeneration(String vehNo);
    
    public ArrayList<OffenceDetailsEO> findOffenceDetails(String vehNum);
    
    
}
