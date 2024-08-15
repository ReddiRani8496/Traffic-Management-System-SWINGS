package tms.business;

import java.util.ArrayList;
import java.util.List;

import tms.entities.OffenceDetailsEO;
import tms.entities.OwnerDetailsEO;
import tms.entities.VehicleDetailsEO;

public interface TCopOperations {
    
    public Integer raiseOffence(OffenceDetailsEO offenceDetailsRef);
    
    public Integer clearOffence(OffenceDetailsEO offenceDetailsRef);
    
    public VehicleDetailsEO fetchVehicleDetails(String vehNo);
    
    public OwnerDetailsEO fetchOwnerDetails(String vehNo);
    
    public ArrayList<OffenceDetailsEO> fetchAllOffencesCommited(String vehNo);
}
